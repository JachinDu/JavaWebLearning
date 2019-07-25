package com.jachin.sell.dao;

import com.jachin.sell.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/07/20 13:44
 */

public interface OrderDetailDao extends JpaRepository<OrderDetail, String> {
    List<OrderDetail> findByOrderId(String orderId);
}
