package com.jachin.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @description: 商品详情(返回给前端)
 * @Author: JachinDo
 * @Date: 2019/07/17 22:48
 */

@Data
public class ProductInfoVO implements Serializable {


    private static final long serialVersionUID = 7936051002128398869L;

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;
}
