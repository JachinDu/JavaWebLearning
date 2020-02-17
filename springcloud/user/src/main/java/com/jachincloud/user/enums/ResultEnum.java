package com.jachincloud.user.enums;

import lombok.Getter;

/**
 * @description: 返回给前端的提示消息
 * @Author: JachinDo
 * @Date: 2019/07/20 15:19
 */
@Getter
public enum ResultEnum {
    LOGIN_FAIL(1, "登录失败"),
    ROLE_ERROR(2,"角色权限有误")
    ;


    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
