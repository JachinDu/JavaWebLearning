package com.jachin.providerdicket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
* 1、将服务提供者注册到注册中心zookeeper
* */

@SpringBootApplication
public class ProviderDicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderDicketApplication.class, args);
	}

}
