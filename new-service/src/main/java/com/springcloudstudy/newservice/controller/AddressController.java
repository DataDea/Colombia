package com.springcloudstudy.newservice.controller;

import com.springcloudstudy.common.bean.Address;
import com.springcloudstudy.common.contorller.BaseController;
import com.springcloudstudy.common.spring.JsonResult;
import com.springcloudstudy.newservice.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author yanghai
 * @date 2018/10/24 11:25
 */
@RestController
@RequestMapping("/addresscontroller")
public class AddressController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(AddressController.class);

    @Autowired
    private AddressService addressService;

    @RequestMapping("/get")
    public JsonResult get(@RequestBody Map<String, Object> params){
        checkParams(params.get("id"), params.get("name"));
        return new JsonResult(addressService.get());
    }
}
