//package com.jachincloud.order.controller;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @description:
// * @Author: JachinDo
// * @Date: 2019/09/20 17:09
// */
//@RequestMapping("/env")
//@RestController
//@RefreshScope
//public class EnvController {
//
//    @Value("${env}")
//    private String env;
//
//    @GetMapping("/print")
//    public String print() {
//        return env;
//    }
//}
