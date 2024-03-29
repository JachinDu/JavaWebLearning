package com.jachincloud.order.enums;

import lombok.Getter;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/07/20 13:35
 */

@Getter
public enum PayStatusEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;

    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
