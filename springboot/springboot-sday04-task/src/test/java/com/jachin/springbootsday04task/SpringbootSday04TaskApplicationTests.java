package com.jachin.springbootsday04task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootSday04TaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject("通知-爱你"); //标题
        message.setText("mua~"); //内容

        //收信人
        message.setTo("785176449@qq.com");
        message.setFrom("jiachengkeep@foxmail.com");//必须与配置文件中的username一致
        mailSender.send(message);
    }

    @Test
    public void test02() throws MessagingException {

        //1、创建一个复杂的消息邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //multipart:true  允许上传附件
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        //邮件设置
        helper.setSubject("通知-爱你"); //标题
        helper.setText("<b style='color:red'>Mua~</b>",true); //内容

        //收信人
        helper.setTo("785176449@qq.com");
        helper.setFrom("jiachengkeep@foxmail.com");//必须与配置文件中的username一致

        //上传文件
        helper.addAttachment("美女.jpg",new File("/Users/jc/Desktop/美女.jpg"));
        mailSender.send(mimeMessage);
    }

}
