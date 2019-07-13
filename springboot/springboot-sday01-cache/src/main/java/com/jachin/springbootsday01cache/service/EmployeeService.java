package com.jachin.springbootsday01cache.service;


import com.jachin.springbootsday01cache.bean.Employee;
import com.jachin.springbootsday01cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;


@CacheConfig(cacheNames = "emp",cacheManager = "empCacheManager")  //抽取方法的统一缓存属性
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;


    /* @Cacheable
    * 将方法结果缓存，再执行同样的方法获取同样的数据时直接取，不用再执行方法
    *   几个属性：
    *       cacheNames/value: 指定缓存组件的名字（用cacheManager中的哪个cache组件），数组的方式可以指定多个缓存
    *       key: 缓存数据时用的key（默认使用方法的参数的值）
    *               可使用spEl写
    *       keyGenerator:  key的生成器：可自己指定生成器的组件id
    *       key/kyeGenerator二选一
    *       cacheManager/cacheResovler: 指定从哪个缓存管理器中获取cache组件
    *       condition: 指定符合条件的情况下才缓存
    *       unless: 否定缓存，与condition相反
    *       sync: 是否使用异步模式
    * */
    @Cacheable(/*cacheNames = {"emp"},*/key = "#id")
    public Employee getEmp(Integer id) {
        System.out.println("查询"+id+"号员工");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }

    /*
     * @CachePut: 既调用方法，又更新缓存；
     *  一定会先调用方法
     *  注意key值统一才可同步更新缓存
     * */
    @CachePut(/*value = "emp",*/key = "#employee.id")
    public Employee updateEmp(Employee employee) {
        System.out.println("updateEmp: "+employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }


    /*
     *  @CacheEvict: 缓存清除
     *     参数：allEntries = true删除所有缓存
     *          beforeInvocation = false;默认false缓存清除是否在方法之前执行
     *                  默认情况下，要是方法内出了异常，则缓存不会清空
     * */
    @CacheEvict(/*value = "emp",*/key = "#id")
    public void deleteEmp(Integer id) {
        System.out.println("deleteEmp: " + id);
//        employeeMapper.deleteEmpById(id);

    }


    /*
    * 指定多个缓存规则：
    *   这里相当于把同一个对象用三种key值放入缓存
    * */

    @Caching(
            cacheable = {
                    @Cacheable(/*value = "emp",*/key = "#lastName")
            },
            put = {
                    @CachePut(/*value = "emp",*/key = "#result.id"),
                    @CachePut(/*value = "emp",*/key = "#result.email")
            }

    )
    public Employee getEmpByLastName(String lastName) {
        return employeeMapper.getEmpByLastName(lastName);
    }
}
