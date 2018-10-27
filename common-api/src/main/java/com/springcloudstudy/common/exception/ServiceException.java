package com.springcloudstudy.common.exception;

import com.springcloudstudy.common.spring.JsonResult;

/**
 * @author yanghai
 * @date 2018/10/27 13:09
 */
public class ServiceException extends RuntimeException {

    private int code;
    private String message;

    public ServiceException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public JsonResult getResult() {
        return new JsonResult(code, message);
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public ServiceException setMessage(String message) {
        this.message = message;
        return this;
    }
}
