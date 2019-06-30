package com.jachin.springbootday03restfulcrud.controller;

import com.jachin.springbootday03restfulcrud.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

//异常处理器注解
@ControllerAdvice
public class MyExceptionHandler {


    //处理指定异常
    //1、浏览器和其他客户端返回的都是json
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String, Object> handleException(Exception e) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("code", "user.notexist");
//        map.put("message", e.getMessage());
//        return map;
//    }



    //2、浏览器显示页面，其他客户端返回json
    //可以将自己定义的数据带过去
    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        //传入自己的错误状态码：4xx，5xx，否则默认200,不会进入定制错误页面解析流程
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code", "user.notexist");
        map.put("message", e.getMessage());

        request.setAttribute("ext",map);
        //转发到/error
        return "forward:/error";
    }
}
