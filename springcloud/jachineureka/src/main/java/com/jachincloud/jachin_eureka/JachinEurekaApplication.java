package com.jachincloud.jachin_eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class JachinEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JachinEurekaApplication.class, args);
    }

}
