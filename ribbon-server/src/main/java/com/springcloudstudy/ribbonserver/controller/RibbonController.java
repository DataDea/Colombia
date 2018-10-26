package com.springcloudstudy.ribbonserver.controller;

import com.springcloudstudy.common.bean.Result;
import com.springcloudstudy.ribbonserver.service.RibbonServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author yanghai
 * @date 2018/10/23 17:14
 */
@RestController
@RequestMapping("/ribboncontroller")
public class RibbonController {

    @Autowired
    RibbonServer ribbonServer;

    @RequestMapping("/getUser")
    public Result getUser(@RequestBody Map<String, Object> params) throws Exception {
        return  ribbonServer.ribbonServerUser(params);
    }

    @RequestMapping("/getAddress")
    public Result getAddress(@RequestBody Map<String, Object> params) {
        return  ribbonServer.ribbonServerAddres(params);
    }
}
