package com.jachin.springbootsday02amqp;

import com.jachin.springbootsday02amqp.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootSday02AmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    //用来用程序创建exchange，queue等
    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void createExchange() {
//        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
//        System.out.println("创建完成");
//        amqpAdmin.declareQueue(new Queue("amqpadmin.queue", true));
        //创建绑定规则
        amqpAdmin.declareBinding(new Binding("amqpadmin.queue",Binding.DestinationType.QUEUE,"amqpadmin.exchange","amqp.hh",null));
    }

    /*
    * 1、单播（点对点）
    * */
    @Test
    public void contextLoads() {
        //message需要自己构造，定义消息体内容和消息头
//        rabbitTemplate.send(exchange,routeKey,message);

        //object默认当成消息体，只需传入要发送到对象，自动序列化
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "这是第一个消息");
        map.put("data", Arrays.asList("helloworld", 123, true));
        //对象被默认序列化之后发送出去
        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",new Book("西游记","吴承恩"));
    }


    //接收数据
    @Test
    public void receive() {
        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    /*
     * 广播
     * */
    @Test
    public void sendBoardCast() {
        rabbitTemplate.convertAndSend("exchange.fanout","",new Book("红11楼梦","曹雪芹"));
    }

}
