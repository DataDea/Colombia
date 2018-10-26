package com.springcloudstudy.newservice;

import com.springcloudstudy.common.bean.Address;
import com.springcloudstudy.newservice.controller.AddressController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewserviceApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private AddressController controller;

    @Test
    public void testGet() {
        Map<String, Object> params = new HashMap<>();
        Address address = controller.get(params);
        System.out.println(address);
    }

}
