package com.tmall.tmallspringboot.dao;

import com.tmall.tmallspringboot.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category,Integer> {
    //大部分crud方法都在JpaRepository中了，所以几乎不用自己定义
}
