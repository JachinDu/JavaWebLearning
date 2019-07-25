package com.jachin.sell.dao;

import com.jachin.sell.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoDao extends JpaRepository<ProductInfo,String> {
    // 根据商品的状态查询所有商品
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
