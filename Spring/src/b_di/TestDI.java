package b_di;

import a_ioc.UserService;
import a_ioc.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class TestDI {

    @Test
    public void demo1() {
        //从spring容器获得
        String xmlPath = "b_di/spring-config-di.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);//！！！该行一执行，就实例化了对象
        BookService bookService = (BookService)applicationContext.getBean("bookService");
        bookService.addBook();
    }

    @Test
    public void demo2() {
        //使用beanFactory
        String xmlPath = "b_di/spring-config-di.xml";
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(xmlPath));
        BookService bookService = (BookService)beanFactory.getBean("bookService");
        bookService.addBook();
    }
}
