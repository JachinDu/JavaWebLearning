package c_dbcp;

import a_domain.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDBCP {

  @Test
  public void demo1() {

      User user = new User();
      user.setId(1);
      user.setUsername("捷克");
      user.setPassword("888");

      String xmlPath = "c_dbcp/spring-config-dbcp.xml";
      ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
      UserDao userDao = (UserDao) applicationContext.getBean("userDao");
      userDao.update(user);

  }
}
