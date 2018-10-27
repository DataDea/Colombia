package com.springcloudstudy.zullserver;

import com.springcloudstudy.zuulserver.ZuulServerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ZuulServerApplication.class)
public class ZuulServerApplicationTests {

    @Test
    public void contextLoads() {
        String fileDir = System.getProperty("user.dir");
        System.out.println(fileDir);
    }

}
