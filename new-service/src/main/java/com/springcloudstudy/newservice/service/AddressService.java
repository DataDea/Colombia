package com.springcloudstudy.newservice.service;

import com.springcloudstudy.newservice.bean.Address;
import org.springframework.stereotype.Service;

/**
 * @author yanghai
 * @date 2018/10/24 11:26
 */
@Service
public class AddressService {


    public Address get() {
        Address address = new Address();
        address.setName("天津");
        address.setInfo("天津市河西区大沽南路1310号天津大学");
        return address;
    }

}
