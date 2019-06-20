package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

public interface SuccessKilledDao {

    /*
    * 插入购买明细（联合主键可过滤重复秒杀）
    *   返回：插入的行数
    * */
    public int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);


    /*
    * 根据id查询SuccessKilled并携带秒杀商品对象
    * */
    public SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
}
