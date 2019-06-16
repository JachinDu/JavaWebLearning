package ssm.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ssm.service.AccountService;

public class testSpring {

    @Test
    public void run1() {
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //获取对象
        AccountService accountService = (AccountService)applicationContext.getBean("accountService");
        //调用方法
        accountService.findAll();
    }
}
