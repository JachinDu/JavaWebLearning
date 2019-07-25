package com.jachin.sell.service;

import com.jachin.sell.dto.OrderDTO;

/**
 * @description: BuyerOrderController 中要调用的特殊service
 * @Author: JachinDo
 * @Date: 2019/07/24 18:00
 */

public interface BuyerService {

    // 查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    // 取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}
