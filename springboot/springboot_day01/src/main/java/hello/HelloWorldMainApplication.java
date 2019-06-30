package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//该注解用来标注这是一个springboot 应用
@SpringBootApplication
public class HelloWorldMainApplication {

    public static void main(String[] args) {

        //spring应用启动
        SpringApplication.run(HelloWorldMainApplication.class, args);
    }
}
