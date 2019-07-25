package com.jachin.sell.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @description: Order相关表单验证
 * @Author: JachinDo
 * @Date: 2019/07/22 18:08
 */
@Data
public class OrderForm {

    // 买家姓名
    @NotEmpty(message = "姓名必填")
    private String name;

    @NotEmpty(message = "手机号码必填")
    private String phone;

    @NotEmpty(message = "地址必填")
    private String address;

    @NotEmpty(message = "openid必填")
    private String openid;

    // 购物车信息(String)
    @NotEmpty(message = "购物车不能为空")
    private String items;

}
