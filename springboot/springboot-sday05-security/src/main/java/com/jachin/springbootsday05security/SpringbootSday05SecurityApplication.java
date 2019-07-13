package com.jachin.springbootsday05security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
* 1、引入springsecurity依赖
*    引入Thymeleaf Extras Springsecurity5依赖
* 2、编写springsecurity配置
* */


@SpringBootApplication
public class SpringbootSday05SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSday05SecurityApplication.class, args);
    }

}
