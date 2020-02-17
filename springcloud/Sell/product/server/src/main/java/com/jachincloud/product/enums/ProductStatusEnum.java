package com.jachincloud.product.enums;

import lombok.Getter;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/09/12 15:27
 */
@Getter
public enum ProductStatusEnum {

    UP(0, "在架"),
    DOWN(1, "下架");

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
