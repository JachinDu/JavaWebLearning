package com.jachin.sell.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jachin.sell.enums.ProductStatusEnum;
import com.jachin.sell.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
@DynamicInsert
public class ProductInfo implements Serializable {


    private static final long serialVersionUID = 7098021557705977721L;
    @Id
    private String productId;

    private String productName;

    private BigDecimal productPrice;
    private Integer productStock;
    private String productDescription;
    private String productIcon;
    // 0在架 1下架
    private Integer productStatus = ProductStatusEnum.UP.getCode();
    private Integer categoryType;

    private Date createTime;
    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }

}
