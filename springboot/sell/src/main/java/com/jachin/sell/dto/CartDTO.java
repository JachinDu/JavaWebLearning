package com.jachin.sell.dto;

import lombok.Data;

/**
 * @description: 购物车
 * @Author: JachinDo
 * @Date: 2019/07/20 16:11
 */
@Data
public class CartDTO {

    // 订单中商品名
    private String productId;
    // 订单中对应商品的数量
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
