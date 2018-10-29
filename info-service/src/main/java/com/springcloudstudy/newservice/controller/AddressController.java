package com.springcloudstudy.newservice.controller;

import com.springcloudstudy.common.bean.Address;
import com.springcloudstudy.common.contorller.BaseController;
import com.springcloudstudy.common.spring.JsonResult;
import com.springcloudstudy.newservice.service.AddressService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author yanghai
 * @date 2018/10/24 11:25
 */
@RestController
@RequestMapping("/addresscontroller")
public class AddressController extends BaseController {

    @Resource
    private AddressService addressService;

    @RequestMapping("/get")
    public JsonResult<Address> get(@RequestBody Map<String, Object> params) {
        checkParams(params.get("id"), params.get("name"));
        return new JsonResult<>(addressService.get());
    }

    @RequestMapping("/info")
    public JsonResult<String> inof(@RequestParam String name) {
        if (!"YH".equals(name)) {
           return new JsonResult<>("failed");
        }
        return new JsonResult<>("success");
    }
}
