package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SeckillDao {

    /*
     * 减库存：
     *       参数对应商品id，和减库存时间
     *       返回： 影响行数>1,表示更新的记录行数
     * */
    public int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /*
     * 根据id查秒杀商品对象
     * */
    public Seckill queryById(long seckillId);

    /*
     * 根据偏移量查询秒杀列表（分页）
     * */
    public List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    /*
    * 使用存储过程执行秒杀
    * */
    void killByProcedure(Map<String, Object> paramMap);
}
