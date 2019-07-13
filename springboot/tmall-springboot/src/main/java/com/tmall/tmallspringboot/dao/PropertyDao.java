package com.tmall.tmallspringboot.dao;

import com.tmall.tmallspringboot.pojo.Category;
import com.tmall.tmallspringboot.pojo.Property;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
* 这个是个接口，它是没有实现类的，至少我们是没有显式提供实现类。 那么要进行条件查询，就是在方法名上面做文章。 比如这里的findByCategory，就是基于Category进行查询，第二个参数传一个 Pageable ， 就支持分页了。
* 这就是JPA所谓的不用写 SQL语句。。。因为需要的信息都在方法名和参数里提供了。
* */
public interface PropertyDao extends JpaRepository<Property,Integer> {

    // 若是按主键查就不用这么写了，对比Category的controller中list()
    Page<Property> findByCategory(Category category, Pageable pageable);


    // 通过分类获取所有属性集合，而不是分页对象
    List<Property> findByCategory(Category category);
}
