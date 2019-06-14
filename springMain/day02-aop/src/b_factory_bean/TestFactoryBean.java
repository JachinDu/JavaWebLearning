package b_factory_bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactoryBean {
    @Test
    public void demo1() {
        String xmlPath = "b_factory_bean/spring-config-factory.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        UserService userService = (UserService) applicationContext.getBean("proxyService");
        userService.addUser();
        userService.updateUser();
        userService.deleteUser();
    }
}
