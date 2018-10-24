package com.springcloudstudy.userservice.service;

import com.springcloudstudy.userservice.bean.User;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author yanghai
 * @date 2018/10/23 17:34
 */
@Service
public class UserService {

    public User get(Map<String, Object> params) {
        User user = new User("PERSON0001", "FH-LRR");
        user.setId((String) params.get("id"));
        user.setName((String) params.get("name"));
        return user;
    }
}
