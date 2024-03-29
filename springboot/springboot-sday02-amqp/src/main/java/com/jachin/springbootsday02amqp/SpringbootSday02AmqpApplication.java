package com.jachin.springbootsday02amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit  //开启基于注解的RabbitMQ
@SpringBootApplication
public class SpringbootSday02AmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSday02AmqpApplication.class, args);
    }

}
