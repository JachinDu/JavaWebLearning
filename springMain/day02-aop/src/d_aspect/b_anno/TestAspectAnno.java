package d_aspect.b_anno;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspectAnno {
    @Test
    public void demo1() {
        String xmlPath = "d_aspect/b_anno/spring-config-aspect-anno.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.addUser();
        userService.updateUser();
        userService.deleteUser();
    }
}
