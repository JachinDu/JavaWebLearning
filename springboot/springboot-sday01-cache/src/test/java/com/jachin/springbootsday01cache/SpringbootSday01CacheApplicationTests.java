package com.jachin.springbootsday01cache;

import com.jachin.springbootsday01cache.bean.Employee;
import com.jachin.springbootsday01cache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootSday01CacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;  //操作key-value都是字符串的

    @Autowired
    RedisTemplate redisTemplate;  //操作key-value都是对象的

    @Autowired
    RedisTemplate<Object,Employee> empredisTemplate;

    /*
    *   String,list,set,hash,zset(有序集合
    *   stringRedisTemplate.opsForValue() -> String
    *   stringRedisTemplate.opsForList() -> List
    *   ....
     * */
    @Test
    public void test01() {
        //给redis中保存数据
//        stringRedisTemplate.opsForValue().append("msg", "hello");

        //读取redis中数据
        String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);
    }

    @Test
    public void test02() {
        Employee emp = employeeMapper.getEmpById(1);
        //默认保存对象时，使用jdk序列化机制，序列化后的数据保存到redis中(看不懂)
        empredisTemplate.opsForValue().set("emp-01",emp);
        //1、将数据以json的方式保存

    }

    @Test
    public void contextLoads() {

        Employee empById = employeeMapper.getEmpById(1);
        System.out.println(empById);
    }

}
