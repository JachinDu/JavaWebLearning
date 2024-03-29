package com.jachin.springbootday01quick;

import com.jachin.springbootday01quick.bean.Person;
import com.jachin.springbootday01quick.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
/*
* springboot单元测试
* 可以在测试期间方便类似编码一样进行自动注入等容器的功能
* */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDay01QuickApplicationTests {

	@Autowired
	Person person;

	@Autowired
	ApplicationContext ioc;

	@Test
	public void testHelloService() {
		boolean b = ioc.containsBean("helloService");
		System.out.println(b);
	}

	@Test
	public void contextLoads() {
		System.out.println(person);
	}

}
