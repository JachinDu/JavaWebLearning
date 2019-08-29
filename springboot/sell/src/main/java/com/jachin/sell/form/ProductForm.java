package com.jachin.sell.form;

import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/08/26 16:21
 */
@Data
public class ProductForm {
    private String productId;

    private String productName;

    private BigDecimal productPrice;
    private Integer productStock;
    private String productDescription;
    private String productIcon;
    private Integer categoryType;
}
