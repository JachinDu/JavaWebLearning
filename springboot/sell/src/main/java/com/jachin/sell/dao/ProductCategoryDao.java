package com.jachin.sell.dao;

import com.jachin.sell.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryDao extends JpaRepository<ProductCategory, Integer> {

    // 查询指定多个类目
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
