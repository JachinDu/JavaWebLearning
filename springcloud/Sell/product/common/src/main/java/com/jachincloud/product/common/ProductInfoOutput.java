package com.jachincloud.product.common;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2020/01/04 18:53
 */
@Data
public class ProductInfoOutput {
    private String productName;
    private String productId;
    private BigDecimal productPrice;
    private Integer productStock;
    private String productDescription;
    private String productIcon;
    // 0在架 1下架
    private Integer productStatus;
    private Integer categoryType;
}
