package com.tmall.tmallspringboot.service;


import com.tmall.tmallspringboot.dao.ReviewDao;
import com.tmall.tmallspringboot.pojo.Product;
import com.tmall.tmallspringboot.pojo.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    ReviewDao reviewDao;
    @Autowired ProductService productService;


    // 增加评论
    public void add(Review review) {
        reviewDao.save(review);
    }

    // 获取评论集合
    public List<Review> list(Product product){
        List<Review> result =  reviewDao.findByProductOrderByIdDesc(product);
        return result;
    }


    // 获取评论数
    public int getCount(Product product) {
        return reviewDao.countByProduct(product);
    }
}
