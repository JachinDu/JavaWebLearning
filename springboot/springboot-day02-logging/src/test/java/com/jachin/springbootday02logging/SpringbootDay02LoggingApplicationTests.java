package com.jachin.springbootday02logging;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDay02LoggingApplicationTests {


    //日志记录器
    Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    public void contextLoads() {

        //日志的级别：
        //由低到高：trace < debug < info < warn < error
        //跳哼输出日志级别：只打印>=该级别的日志信息（默认是info级别）
        logger.trace("这是trace日志。。。");
        logger.debug("这是debug日志。。。");
        logger.info("这是info。。。");
        logger.warn("这是warn...");
        logger.error("这是error。。。");
    }

}
