package com.jachincloud.order.enums;

import lombok.Getter;

/**
 * @description: 订单状态枚举类
 * @Author: JachinDo
 * @Date: 2019/07/18 21:35
 */

@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINISHED(1, "已完结"),
    CANCEL(2, "已取消"),
    ;
    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
