package com.jachin.sell.enums;

import lombok.Getter;

/**
 *
 * @Author: JachinDo
 * @Date: 2019/07/16 17:15
 */
@Getter
public enum ProductStatusEnum implements CodeEnum{

    UP(0,"在架"),
    DOWN(1,"下架");

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
