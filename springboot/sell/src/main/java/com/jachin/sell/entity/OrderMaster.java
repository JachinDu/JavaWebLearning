package com.jachin.sell.entity;

import com.jachin.sell.enums.OrderStatusEnum;
import com.jachin.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    // 默认为未支付 0
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    private Date createTime;
    private Date updateTime;



}
