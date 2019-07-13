package com.tmall.tmallspringboot.dao;

import com.tmall.tmallspringboot.pojo.Product;
import com.tmall.tmallspringboot.pojo.Property;
import com.tmall.tmallspringboot.pojo.PropertyValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyValueDAO extends JpaRepository<PropertyValue,Integer> {

    // 根据产品查询
    List<PropertyValue> findByProductOrderByIdDesc(Product product);

    // 根据产品和属性查询
    PropertyValue getByPropertyAndProduct(Property property, Product product);
}
