package com.springcloudstudy.ribbonserver.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloudstudy.common.bean.*;
import com.springcloudstudy.common.spring.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author yanghai
 * @date 2018/10/23 17:15
 */
@Service
public class RibbonServer {

    private static Logger logger = LoggerFactory.getLogger(RibbonServer.class);

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "ribbonServerError")
    public JsonResult ribbonServerUser(Map<String, Object> params) {
        User user;
        try {
            ResponseEntity<User> entity = restTemplate.postForEntity("http://user-service/usercontroller/get", params, User.class);
            user = entity.getBody();
        } catch (Exception e) {
            throw JsonResult.ERR_USER_SERVICE;
        }
        if (null == user) {
            throw JsonResult.ERR_USER_NOT_EXIST;
        }
        return new JsonResult(user);
    }

    @HystrixCommand(fallbackMethod = "ribbonServerError")
    public JsonResult ribbonServerAddress(Map<String, Object> params) {
        Address address;
        try {
            ResponseEntity<Address> entity = restTemplate.postForEntity("http://new-service/addresscontroller/get", params, Address.class);
            address = entity.getBody();
        } catch (Exception e) {
            throw JsonResult.ERR_ADDRESS_SERVICE;
        }
        if (null == address) {
            throw JsonResult.ERR_UER_ADDRESS_EXIST;
        }
        return new JsonResult(address);
    }

    public JsonResult ribbonServerError(Map<String, Object> params) {
        return new JsonResult(500, "内部服务错误");
    }
}
