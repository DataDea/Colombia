package com.springcloudstudy.userservice.service;

import com.springcloudstudy.userservice.bean.Address;
import com.springcloudstudy.userservice.bean.User;
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


    @Autowired
    RestTemplate restTemplate;

    public User get(Map<String, Object> params) {
        User user = new User();
        user.setId((String) params.get("id"));
        user.setName((String) params.get("name"));
        try {
            Address address = restTemplate.postForEntity("http://new-service/addresscontroller/get", params, Address.class).getBody();
            user.setAddress(address);
        }catch (Exception e){
            user.setAddress(null);
        }
        return user;
    }
}
