package com.tmall.tmallspringboot.dao;

import com.tmall.tmallspringboot.pojo.Order;
import com.tmall.tmallspringboot.pojo.OrderItem;
import com.tmall.tmallspringboot.pojo.Product;
import com.tmall.tmallspringboot.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemDAO extends JpaRepository<OrderItem,Integer> {

    // 这种方式在命名里提供OrderByIdDesc，就进行到排序了，就可以不用传Sort参数了
    List<OrderItem> findByOrderOrderByIdDesc(Order order);

    // 为获取某产品的销量做准备
    List<OrderItem> findByProduct(Product product);

    // 显示还没成功购买的商品
    List<OrderItem> findByUserAndOrderIsNull(User user);
}

