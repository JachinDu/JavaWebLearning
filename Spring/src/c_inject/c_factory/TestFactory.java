package c_inject.c_factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactory {
    @Test
    public void demo1() {
        //自定义实例工厂
        //1创建工厂
        MyBeanFactory myBeanFactory = new MyBeanFactory();
        UserService userService = myBeanFactory.createService();
        userService.addUser();
    }

    @Test
    public void demo2() {
        //spring工厂
        String xmlPath = "c_inject/c_factory/spring-config-factory.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.addUser();
    }
}
