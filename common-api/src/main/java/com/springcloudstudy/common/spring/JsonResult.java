package com.springcloudstudy.common.spring;


import com.springcloudstudy.common.exception.ServiceException;

/**
 *
 * @author yanghai
 * @date 14-12-12
 */
public class JsonResult {

    public static final ServiceException ERR_INVALID_PARAMS = new ServiceException(1000, "请求参数异常");
    public static final ServiceException ERR_USER_NOT_EXIST = new ServiceException(1001, "用户不存在");
    public static final ServiceException ERR_UER_ADDRESS_EXIST = new ServiceException(1002, "地址不存在");
    public static final ServiceException ERR_USER_SERVICE = new ServiceException(1003, "用户服务异常");
    public static final ServiceException ERR_ADDRESS_SERVICE = new ServiceException(1004, "地址服务异常");

    public int code;

    public String message;

    public Object data;

    /**
     * 成功返回
     */
    public JsonResult() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 成功返回
     */


    public JsonResult(Object data) {
        this.data = data;
    }

    public JsonResult(int code, String message) {
        this.code = code;
        this.message = message;
    }



}
