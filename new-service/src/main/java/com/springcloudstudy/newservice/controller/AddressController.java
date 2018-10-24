package com.springcloudstudy.newservice.controller;

import com.springcloudstudy.newservice.bean.Address;
import com.springcloudstudy.newservice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author yanghai
 * @date 2018/10/24 11:25
 */
@RestController
@RequestMapping("/addresscontroller")
public class AddressController {


    @Autowired
    private AddressService addressService;

    @RequestMapping("/get")
    public Address get(@RequestBody Map<String, Object> params){
        if (params == null ) {
            throw new RuntimeException("检查参数错误");
        }
        Address address = addressService.get();
        return address;
    }
}
