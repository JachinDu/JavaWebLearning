package com.jachin.springbootday01quick.config;


import com.jachin.springbootday01quick.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
* Configuration指明这是一个配置类
* 用来替代之前的spring配置文件<bean></bean>
*
* */
@Configuration
public class MyAppConfig {

    //@Bean将方法的返回值添加到容器中:
        //该组件的默认id就是方法名
    @Bean
    public HelloService helloService() {
        System.out.println("配置类@Bean");
        return new HelloService();
    }
}
