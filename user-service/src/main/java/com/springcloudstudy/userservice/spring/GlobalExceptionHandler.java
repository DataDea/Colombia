package com.springcloudstudy.userservice.spring;

import com.springcloudstudy.common.exception.ServiceException;
import com.springcloudstudy.common.spring.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by sudongsheng on 2018/7/2
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 自定义异常
     */
    @ResponseBody
    @ExceptionHandler({ServiceException.class, NoHandlerFoundException.class,
            SQLException.class, HttpMessageNotReadableException.class, HttpMediaTypeNotSupportedException.class,
            NullPointerException.class, IOException.class})
    public JsonResult handleJsonException(HttpServletRequest request, Exception e) {
        if (e instanceof ServiceException) { //自定义异常
            return ((ServiceException) e).getResult();
        }
        return new JsonResult();
    }

    /**
     * 全局Exception异常捕捉处理
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String handleException(HttpServletRequest request, Exception e) {
        if (e instanceof HttpMediaTypeNotAcceptableException) { //内容错误
            logger.warn("HttpMediaTypeNotAcceptableException[" + request.getRequestURI() + "],content-type[" + request.getContentType() + "]");
        } else {
            logger.warn("[" + request.getRequestURI() + "]", e);
            return "unknown error: uri[" + request.getRequestURI() + "], error[" + e.toString() + "]";
        }
        return null;
    }
}
