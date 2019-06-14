package c_c3p0;

import a_domain.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestC3P0 {

  @Test
  public void demo1() {

//      User user = new User();
//      user.setId(2);
//      user.setUsername("肉丝");
//      user.setPassword("888");

      String xmlPath = "c_c3p0/spring-config-c3p0.xml";
      ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
      UserDao userDao = (UserDao) applicationContext.getBean("userDao");
//      userDao.update(user);
      List<User> allUser = userDao.findAll();
      for (User user : allUser) {
          System.out.println(user);
      }

  }
}
