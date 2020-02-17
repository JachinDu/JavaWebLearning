package com.jachincloud.user.enums;

import lombok.Getter;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2020/01/07 17:01
 */
@Getter
public enum RoleEnum {

    BUYER(1, "买家"),
    SELLER(2, "卖家"),
    ;

    private Integer code;
    private String message;

    RoleEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
