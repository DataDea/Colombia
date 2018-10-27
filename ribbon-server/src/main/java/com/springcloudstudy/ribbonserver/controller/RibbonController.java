package com.springcloudstudy.ribbonserver.controller;

import com.springcloudstudy.common.contorller.BaseController;
import com.springcloudstudy.common.spring.JsonResult;
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
public class RibbonController extends BaseController {

    @Autowired
    RibbonServer ribbonServer;

    @RequestMapping("/getUser")
    public JsonResult getUser(@RequestBody Map<String, Object> params) throws Exception {
        checkParams(params.get("id"), params.get("name"));
        return ribbonServer.ribbonServerUser(params);
    }

    @RequestMapping("/getAddress")
    public JsonResult getAddress(@RequestBody Map<String, Object> params) {
        checkParams(params.get("id"), params.get("name"));
        return ribbonServer.ribbonServerAddress(params);
    }
}
