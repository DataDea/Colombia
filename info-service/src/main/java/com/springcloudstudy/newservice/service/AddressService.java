package com.springcloudstudy.newservice.service;

import com.springcloudstudy.common.bean.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author yanghai
 * @date 2018/10/24 11:26
 */
@Service
public class AddressService {

    private static Logger logger = LoggerFactory.getLogger(AddressService.class);

    public Address get() {
        logger.info("start service.....");
        Address address = new Address();
        address.setName("天津");
        address.setInfo("天津市河西区大沽南路1310号天津大学");
        logger.info("end service....");
        return address;
    }

}
