package f_setter_invasion;

import b_di.BookService;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class TestSetterInvasion {

    @Test
    public void demo1() {
        String xmlPath = "f_setter_invasion/spring-config-p.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        Person person = (Person) applicationContext.getBean("Person");
        System.out.println(person);
    }

}
