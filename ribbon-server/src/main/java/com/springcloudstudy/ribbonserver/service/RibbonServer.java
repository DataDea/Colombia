package com.springcloudstudy.ribbonserver.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloudstudy.ribbonserver.bean.Address;
import com.springcloudstudy.ribbonserver.bean.Result;
import com.springcloudstudy.ribbonserver.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public Result ribbonServerUser(Map<String, Object> params) throws Exception {
        Result result = new Result();
        User user =null;
        try {
            ResponseEntity<User> entity = restTemplate.postForEntity("http://user-service/usercontroller/get", params, User.class);
            user = entity.getBody();
        }catch (Exception e) {
            System.out.println(e);
        }
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

    @HystrixCommand(fallbackMethod = "ribbonServerError")
    public Result ribbonServerAddres(Map<String, Object> params) {
        Result result = new Result();
        ResponseEntity<Address> entity = restTemplate.postForEntity("http://new-service/addresscontroller/get", params, Address.class);
        Address address = entity.getBody();
        if (null == address) {
            result.setCode("0");
            result.setMessage("当前地址不存在");
            result.setData(null);
        } else {
            result.setCode("1");
            result.setMessage(null);
            result.setData(address);
        }
        return result;
    }

    public Result ribbonServerError(Map<String, Object> params) {
        return new Result("500", "内部服务错误", null);
    }
}
