package com.springcloudstudy.userservice.controller;

import com.springcloudstudy.userservice.bean.User;
import com.springcloudstudy.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author yanghai
 * @date 2018/10/23 17:34
 */
@RestController
@RequestMapping("/usercontroller")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/get")
    public User get(@RequestBody Map<String, Object> params) {
        User user = userService.get(params);
        return user;
    }
}
