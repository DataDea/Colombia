package com.springcloudstudy.common.contorller;

import com.springcloudstudy.common.spring.JsonResult;

/**
 * @author yanghai
 * @date 2018/10/27 13:20
 */
public class BaseController {

    /**
     * 检查参数
     */
    protected void checkParams(Object... params) {
        for (Object o : params) {
            if (o == null) {
                throw JsonResult.ERR_INVALID_PARAMS;
            } else if (o instanceof Number) {
                if (((Number) o).intValue() == 0) {
                    throw JsonResult.ERR_INVALID_PARAMS;
                }
            } else if (o instanceof String) {
                if (((String) o).length() == 0) {
                    throw JsonResult.ERR_INVALID_PARAMS;
                }
            }
        }
    }
}
