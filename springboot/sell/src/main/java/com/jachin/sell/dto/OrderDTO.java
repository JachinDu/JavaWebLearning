package com.jachin.sell.dto;

        import com.fasterxml.jackson.annotation.JsonIgnore;
        import com.fasterxml.jackson.annotation.JsonInclude;
        import com.fasterxml.jackson.databind.annotation.JsonSerialize;
        import com.jachin.sell.entity.OrderDetail;
        import com.jachin.sell.enums.OrderStatusEnum;
        import com.jachin.sell.enums.PayStatusEnum;
        import com.jachin.sell.utils.EnumUtil;
        import com.jachin.sell.utils.serializer.Date2LongSerializer;
        import lombok.Data;

        import java.math.BigDecimal;
        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;

/**
 * @description: 与前端订单交互的对象
 * @Author: JachinDo
 * @Date: 2019/07/20 14:39
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)  // 返会给前端是，为null的属性值不返回
public class OrderDTO {

    // 与orderMaster相同
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

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    // 比OrderMaster多了一个订单详情列表项的属性
    List<OrderDetail> orderDetailList;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }

}
