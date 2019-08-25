package com.jachin.sell.service;

import com.jachin.sell.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;

/**
 * @description: 支付
 * @Author: JachinDo
 * @Date: 2019/08/10 10:26
 */

public interface PayService {

    PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

    RefundResponse refund(OrderDTO orderDTO);
}
