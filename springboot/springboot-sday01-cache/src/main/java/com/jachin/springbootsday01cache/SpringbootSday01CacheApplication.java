package com.jachin.springbootsday01cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


/*
* 一、搭建基本环境
* 1、导入数据库文件
* 2、创建javabean封装数据库数据
* 3、整合mybatis操作数据库
*       1）配置数据源信息
*       2）使用注解版mybatis
*
* 二、体验缓存
*   1、开启基于注解的缓存
*   2、标注缓存注解即可
*           @Cacheable  @CacheEvict @CachePut
* */
@EnableCaching  //开启基于注解的缓存
@MapperScan("com.jachin.springbootsday01cache.mapper")
@SpringBootApplication
public class SpringbootSday01CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSday01CacheApplication.class, args);
    }

}
