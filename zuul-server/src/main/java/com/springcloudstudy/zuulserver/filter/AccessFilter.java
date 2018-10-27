package com.springcloudstudy.zuulserver.filter;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.springcloudstudy.common.util.CommonUtils;
import com.springcloudstudy.zuulserver.common.Signer;
import com.springcloudstudy.zuulserver.common.ZuulConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yanghai
 * @date 2018/10/18 16:08
 */
@Component
public class AccessFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        //避免中文乱码
        context.getResponse().setCharacterEncoding("UTF-8");
        logger.info("receive request[" + request.getRequestURI() + "], ip[" + request.getHeader("X-Real-IP") + "]");
        boolean sing = checkSing(request);
        if (!sing) {
            context.setSendZuulResponse(false);
            context.setResponseBody("{\"code\":\"4001\",\"msg\":\"非法请求头\"}");
            context.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());//401
        }
        return null;
    }

    /**
     *请求的签名校验
     */
    private boolean checkSing(HttpServletRequest request) {
        logger.info("[请求URL" + request.getRequestURI() + "]");
        //检查公共请求头参数
        String nonce = request.getHeader("X-Nonce");
        String timestampStr = request.getHeader("X-Timestamp");
        String timeoutStr = request.getHeader("X-Timeout");
        String signature = request.getHeader("X-Signature");
        if (StringUtils.isEmpty(nonce) || StringUtils.isEmpty(timestampStr)
                || StringUtils.isEmpty(timeoutStr) || StringUtils.isEmpty(signature) ||
                CommonUtils.isNotNumber(timeoutStr) || CommonUtils.isNotNumber(timeoutStr)) {
            return false;
        }
        long timestamp = Long.parseLong(timestampStr);
        long timeout = Long.parseLong(timeoutStr);
        if (Math.abs(System.currentTimeMillis() - timestamp * ZuulConfig.CLOCK_SNAP) > ZuulConfig.CLOCK_DELTA + timeout * 1000) {
            return false;
        }

        String userId = request.getHeader("X-User-Id");

        if (StringUtils.isEmpty(userId)) {
            return false;
        }
        return Signer.checkSigner(timestamp, timeout, nonce, ZuulConfig.TOKEN, signature);
    }


    /**
     IP检查
     */
    private boolean checkIp(RequestContext context) {

        return true;
    }


}
