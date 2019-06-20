package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

import java.util.List;

/*
* 业务接口：站在 "使用者" 的角度设计接口
*       1)方法定义粒度
*       2)参数
*       3)返回类型（友好）
* */
public interface SeckillService {

    /*
    * 查询所有秒杀记录
    * */
    public List<Seckill> getSeckillList();

    /*
     * 查询单个秒杀记录
     * */
    public Seckill getById(long seckillId);


    /*
     * 秒杀开启时，输出秒杀接口地址，
     * 否则输出系统时间和秒杀时间
     * 这里就需要dto
     * */
    public Exposer exportSeckillUrl(long seckillId);


    /*
     *执行秒杀
     * */
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException, RepeatKillException, SeckillCloseException;

    /*
     *执行秒杀 by存储过程
     * */
    public SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5)
            throws SeckillException, RepeatKillException, SeckillCloseException;

}
