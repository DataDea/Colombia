package com.springcloudstudy.userservice.controller;

import com.springcloudstudy.common.bean.User;
import com.springcloudstudy.common.contorller.BaseController;
import com.springcloudstudy.common.spring.JsonResult;
import com.springcloudstudy.userservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class UserController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/get")
    public User get(@RequestBody Map<String, Object> params) {
        checkParams(params.get("id"), params.get("name"));
        logger.info("/usercontroller/get");
        User user = userService.get(params);
        return user;
    }

    @RequestMapping("/info")
    public JsonResult info(@RequestBody Map<String, Object> params) {
        checkParams(params.get("id"), params.get("name"));
        User info = userService.info(params);
        return new JsonResult(info);
    }

}
