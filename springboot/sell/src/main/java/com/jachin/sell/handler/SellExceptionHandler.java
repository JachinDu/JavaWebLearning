package com.jachin.sell.handler;

import com.jachin.sell.VO.ResultVO;
import com.jachin.sell.exception.SellException;
import com.jachin.sell.exception.SellerAuthorizeException;
import com.jachin.sell.utils.ResultVOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/08/27 17:18
 */
@ControllerAdvice
public class SellExceptionHandler {

    // 拦截登录异常
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException() {
        //跳转到登录界面(扫码界面)
        return new ModelAndView("redirect:https://open.weixin.qq.com/connect/qrconnect?appid=wx6ad144e54af67d87&redirect_uri=http%3A%2F%2Fsell.springboot.cn%2Fsell%2Fqr%2FoTgZpwTykQPhdjiI8rWYEgXjWhI8&response_type=code&scope=snsapi_login&state=http%3a%2f%2fjachin2013.natapp1.cc%2fsell%2fwechat%2fqrUserInfo");

    }

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellerException(SellException e) {
        return ResultVOUtils.error(e.getCode(),e.getMessage());
    }

}
