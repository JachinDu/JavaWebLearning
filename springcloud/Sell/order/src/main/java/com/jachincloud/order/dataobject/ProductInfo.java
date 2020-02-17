package com.jachincloud.order.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/09/12 15:09
 */
@Data
@Entity
public class ProductInfo {

    @Id
    private String productId;

    private String productName;

    private BigDecimal productPrice;
    private Integer productStock;
    private String productDescription;
    private String productIcon;
    // 0在架 1下架
    private Integer productStatus;
    private Integer categoryType;

//    private Date createTime;
//    private Date updateTime;
}
