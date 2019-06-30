package com.jachin.springbootday01quick;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
//导入spring配置文件，让其生效
//@ImportResource(locations = {"classpath:beans.xml"})

public class SpringbootDay01QuickApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringbootDay01QuickApplication.class, args);
	}

}
