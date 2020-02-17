package com.jachincloud.order.service;

import com.jachincloud.order.dto.OrderDTO;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/09/12 16:23
 */

public interface OrderService {
    // 创建订单
    OrderDTO create(OrderDTO orderDTO);


    /**
     * 完结订单(只能买家操作)
     * @param orderId
     * @return
     */
    OrderDTO finish(String orderId);
}
