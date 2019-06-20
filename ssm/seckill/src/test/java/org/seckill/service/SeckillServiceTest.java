package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
//上面要将两个xml都放上，因为spring-service.xml中的dataSource在dao.xml中
public class SeckillServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private  SeckillService seckillService;


    @Test
    public void testGetSeckillList() throws Exception {
        List<Seckill> list = seckillService.getSeckillList();
        //{}为占位符
        logger.info("list={}",list);
    }

    @Test
    public void testGetById() throws Exception {
        long id = 1001;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill={}",seckill);
    }

    @Test
    public void testExportSeckillUrl() throws Exception {
        long id = 1001;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        logger.info("exposer={}",exposer);
    }

    @Test
    public void testExecuteSeckill() throws Exception {
        long id = 1000;
        long phone = 1356784758L;
        String md5 = "6c3e0221554e1a64ec3b6cdbe778059d";
        SeckillExecution execution = seckillService.executeSeckill(id, phone, md5);
        logger.info("result={}",execution);
    }

    @Test
    public void testexecuteSeckillProcedure() {
        long seckillId = 1002;
        long phone = 15555555555L;
        Exposer exposer = seckillService.exportSeckillUrl(seckillId);
        if (exposer.isExposed()) {
            String md5 = exposer.getMd5();
            SeckillExecution execution = seckillService.executeSeckillProcedure(seckillId,phone,md5);
            logger.info(execution.getStateInfo());
        }



    }

}