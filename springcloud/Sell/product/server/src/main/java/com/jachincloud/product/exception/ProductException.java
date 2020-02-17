package com.jachincloud.product.exception;

import com.jachincloud.product.enums.ResultEnum;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/09/17 12:25
 */

public class ProductException extends RuntimeException {
    private Integer code;

    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
