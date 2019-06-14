package g_collection_invasion;

import f_setter_invasion.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCollectionInvasion {

    @Test
    public void demo1() {
        String xmlPath = "g_collection_invasion/spring-config-coll.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        CollData collData = (CollData) applicationContext.getBean("collData");
        System.out.println(collData);
    }

}
