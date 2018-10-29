package com.springcloudstudy.common;

import com.springcloudstudy.common.spring.JsonResult;
import com.springcloudstudy.common.util.JacksonUtil;
import org.junit.Test;

/**
 * @author yanghai
 * @date 2018/10/29 14:43
 */
public class CommonTest {

    @Test
    public void convertObjToJson() {
        String s = JacksonUtil.convertObjecToJson(JsonResult.ERR_INVALID_HEADER.getResult());
        System.out.println(s);
    }

}
