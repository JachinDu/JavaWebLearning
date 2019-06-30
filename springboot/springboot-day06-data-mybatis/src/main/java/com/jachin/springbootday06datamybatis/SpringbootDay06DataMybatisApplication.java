package com.jachin.springbootday06datamybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.jachin.springbootday06datamybatis.mapper")
@SpringBootApplication
public class SpringbootDay06DataMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDay06DataMybatisApplication.class, args);
    }

}
