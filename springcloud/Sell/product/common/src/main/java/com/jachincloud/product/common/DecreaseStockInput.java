package com.jachincloud.product.common;

import lombok.Data;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2020/01/04 18:58
 */
@Data
public class DecreaseStockInput {
    // 订单中商品名
    private String productId;
    // 订单中对应商品的数量
    private Integer productQuantity;

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    public DecreaseStockInput() {
    }
}
