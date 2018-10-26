package com.springcloudstudy.zuulserver.filter;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.springcloudstudy.zuulserver.common.CommonUtils;
import com.springcloudstudy.zuulserver.common.Signer;
import com.springcloudstudy.zuulserver.common.ZuulConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yanghai
 * @date 2018/10/18 16:08
 */
@Component
public class MyPreDecorationFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(MyPreDecorationFilter.class);

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
        logger.info("receive request[" + request.getRequestURI() + "], ip[" + request.getHeader("X-Real-IP") + "]");
        boolean sing = checkSing(request);
        if (!sing) {
            context.set("error.status_code", HttpServletResponse.SC_FORBIDDEN);
            context.set("error.message", "非法请求头");
            context.set("error.exception", null);
        }
        return null;
    }


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
        //检查用户ID参数
        String accountId = request.getHeader("X-Account-Id");
        String customerId = request.getHeader("X-Customer-Id");
        String userId = request.getHeader("X-User-Id");

        if (StringUtils.isEmpty(accountId) && StringUtils.isEmpty(customerId) && StringUtils.isEmpty(userId)) {
            return false;
        }
        return Signer.checkSigner(timestamp, timeout, nonce, ZuulConfig.TOKEN, signature);
    }


    private boolean checkIp(RequestContext context) {

        return true;
    }


}
