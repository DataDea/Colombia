package com.springcloudstudy.userservice.service;

import com.springcloudstudy.userservice.bean.Address;
import com.springcloudstudy.userservice.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author yanghai
 * @date 2018/10/23 17:34
 */
@Service
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    RestTemplate restTemplate;

    public User get(Map<String, Object> params) {
        logger.info("start service .... ");
        User user = new User();
        user.setId((String) params.get("id"));
        user.setName((String) params.get("name"));
        try {
            Address address = restTemplate.postForEntity("http://new-service/addresscontroller/get", params, Address.class).getBody();
            user.setAddress(address);
        }catch (Exception e){
            user.setAddress(null);
        }
        logger.info("start service ... ");
        return user;
    }
}
