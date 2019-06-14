package e_lifecycle;

import c_inject.c_factory.MyBeanFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCycle {
    @Test
    public void demo2() {
        //spring工厂
        String xmlPath = "e_lifecycle/spring-config-life.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.addUser();

        //要求，容器必须close，销毁方法才能执行，且必须单例
        //close方法接口中没有定义，实现类提供，所以可以通过反射访问
        //1。反射
//        applicationContext.getClass().getMethod("close").invoke(applicationContext);
        //2。直接用实现类调用，将applicationContext类型改为ClassPathXmlApplicationContext，再直接调用close
        applicationContext.close();
    }
}
