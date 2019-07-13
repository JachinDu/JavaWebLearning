package com.jachin.springbootsday03elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
* springboot提供两种技术支持和ES的交互
*   1、Jest（默认不生效）
*       导入jest工具包
*   2、springdata elasticsearch
* */

@SpringBootApplication
public class SpringbootSday03ElasticApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSday03ElasticApplication.class, args);
    }

}
