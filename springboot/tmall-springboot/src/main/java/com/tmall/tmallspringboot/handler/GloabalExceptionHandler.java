package com.tmall.tmallspringboot.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/*
* 全局异常处理类
* */
@RestController
@ControllerAdvice
public class GloabalExceptionHandler {

    public String defaultErrorHandler(HttpServletRequest req, Exception e) throws ClassNotFoundException {
        e.printStackTrace();
        Class constraintViolationException = Class.forName("org.hibernate.exception.ConstraintViolationException");
        if (null != e.getCause() && constraintViolationException==e.getCause().getClass()) {
            return "违反了约束，多半是外键约束";
        }
        return e.getMessage();
    }
}
