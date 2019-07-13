package com.jachin.springbootsday04task.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {


    /*
    * cron格式：秒 分 时 日 月 周几
    *       0 * * * * MON-FRI  代表整秒启动,即每分钟启动一次
    * */
//    @Scheduled(cron = "0 * * * * MON-FRI")
//    @Scheduled(cron = "0-4 * * * * MON-FRI")
    public void hello() {
        System.out.println("hello....");
    }
}
