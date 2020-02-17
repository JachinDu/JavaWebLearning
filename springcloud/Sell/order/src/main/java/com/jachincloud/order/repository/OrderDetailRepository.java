package com.jachincloud.order.repository;

import com.jachincloud.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/09/12 16:13
 */

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
    List<OrderDetail> findByOrderId(String orderId);
}
