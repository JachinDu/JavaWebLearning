package com.jachincloud.order.exception;

import com.jachincloud.order.enums.ResultEnum;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/09/12 16:35
 */

public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
