package com.tmall.tmallspringboot.dao;

import com.tmall.tmallspringboot.pojo.Order;
import com.tmall.tmallspringboot.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDAO extends JpaRepository<Order,Integer> {
    public List<Order> findByUserAndStatusNotOrderByIdDesc(User user, String status);
}
