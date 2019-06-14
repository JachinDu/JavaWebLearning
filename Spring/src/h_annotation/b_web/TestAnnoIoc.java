package h_annotation.b_web;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnoIoc {

    @Test
    public void demo2() {
        //从spring容器获得
        //1.获得容器
        String xmlPath = "h_annotation/b_web/spring-config.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        //2.获得内容---不需要自己new，都从spring容器中获得
        StudentAction studentAction = (StudentAction) applicationContext.getBean("studentAction");  //传入配置文件中对应类的id值
        studentAction.execute();
    }
}