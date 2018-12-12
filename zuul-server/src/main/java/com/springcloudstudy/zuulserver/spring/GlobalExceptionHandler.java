package com.springcloudstudy.zuulserver.spring;

import com.springcloudstudy.common.exception.ServiceException;
import com.springcloudstudy.common.spring.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by sudongsheng on 2018/7/2
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception e, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        JsonResult result = null;
        if (e instanceof ServiceException) {
            result = ((ServiceException) e).getResult();
        }
        return super.handleExceptionInternal(e, result, headers, status, request);
    }


}
