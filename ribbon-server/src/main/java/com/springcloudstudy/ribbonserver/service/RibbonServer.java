package com.springcloudstudy.ribbonserver.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloudstudy.ribbonserver.bean.Result;
import com.springcloudstudy.ribbonserver.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author yanghai
 * @date 2018/10/23 17:15
 */
@Service
public class RibbonServer {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "ribbonServerError")
    public Result ribbonServer(Map<String, Object> params) {
        Result result = new Result();
        MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add((String) params.get("id"), params.get("name"));
        User user = restTemplate.postForObject("http://user-service/usercontroller/get", params, User.class);
        if (null == user) {
            result.setCode("0");
            result.setMessage("当前用户不存在");
            result.setData(null);
        } else {
            result.setCode("1");
            result.setMessage(null);
            result.setData(user);
        }
        return result;
    }

    public Result ribbonServerError(Map<String, Object> params) {
        return new Result("500", "内部服务错误", null);
    }
}
