package com.tmall.tmallspringboot.dao;

import com.tmall.tmallspringboot.pojo.Product;
import com.tmall.tmallspringboot.pojo.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageDAO extends JpaRepository<ProductImage, Integer> {

    // 按照产品和类型（单一/细节）查找图片
    public List<ProductImage> findByProductAndTypeOrderByIdDesc(Product product, String type);
}
