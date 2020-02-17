package com.jachincloud.order.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/07/18 21:28
 */

@Data
@Entity
@DynamicUpdate
@DynamicInsert
public class OrderMaster {

    @Id
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal orderAmount;
    // 默认为新订单 0
    private Integer orderStatus;
    // 默认为未支付 0
    private Integer payStatus;

    private Date createTime;
    private Date updateTime;


}
