package com.tmall.tmallspringboot.dao;

import com.tmall.tmallspringboot.pojo.Product;
import com.tmall.tmallspringboot.pojo.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewDao extends JpaRepository<Review,Integer> {

    List<Review> findByProductOrderByIdDesc(Product product);
    int countByProduct(Product product);  // 获取评论数
}
