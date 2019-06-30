package com.jachin.springbootday03restfulcrud.controller;

import com.jachin.springbootday03restfulcrud.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user) {

        if (user.equals("aaa")) {
            throw new UserNotExistException();
        }
        return "Hello World";
    }


    //查出一些数据，在页面展示
    @RequestMapping("/success")
    public String success(Map<String,Object> map) {
        //该数据默认被放入request域中
        map.put("hello", "<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        //位置：classpath:/templates/success.html
        return "success";
    }
}
