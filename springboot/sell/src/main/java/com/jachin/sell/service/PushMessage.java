package com.jachin.sell.service;

import com.jachin.sell.dto.OrderDTO;

/**
 * @description: 推送消息
 * @Author: JachinDo
 * @Date: 2019/08/27 19:21
 */

public interface PushMessage {

    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
