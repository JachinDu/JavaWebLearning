package a_ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoc {
    @Test
    public void demo1() {
        //之前开发
        UserService userService = new UserServiceImpl();
        userService.addUser();
    }

    @Test
    public void demo2() {
        //从spring容器获得
        //1.获得容器
        String xmlPath = "spring-config.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        //2.获得内容---不需要自己new，都从spring容器中获得
        UserService userService = (UserService) applicationContext.getBean("userService");  //传入配置文件中对应类的id值
        userService.addUser();
    }
}
