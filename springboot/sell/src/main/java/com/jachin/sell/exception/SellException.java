package com.jachin.sell.exception;

import com.jachin.sell.enums.ResultEnum;

/**
 * @description: 自定义异常类
 * @Author: JachinDo
 * @Date: 2019/07/20 15:14
 */

public class SellException extends RuntimeException{

    private Integer code;

    // RuntimeException本来就有message属性，所以把我们定义的message传入super就行
    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }


    // BuyerOrderController中的create方法需要知道具体哪个参数出错，所以这样的异常构造更适合，
    // 直接传入ResultEnum的话没法知道哪个参数出错
    public SellException(Integer code,String message) {
        super(message);
        this.code = code;
    }
}
