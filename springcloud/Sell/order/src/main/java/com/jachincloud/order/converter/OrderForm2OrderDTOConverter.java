package com.jachincloud.order.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jachincloud.order.dataobject.OrderDetail;
import com.jachincloud.order.dto.OrderDTO;
import com.jachincloud.order.enums.ResultEnum;
import com.jachincloud.order.exception.OrderException;
import com.jachincloud.order.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/07/22 21:46
 */

@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {

        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();

        // 这里不用BeanUtils进行属性拷贝是因为两个实体类的对应字段名称不同，无法拷贝
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();

        try {

            // 将json字符串转换为List
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception e) {
            log.error("【对象转换】错误，String={}", orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }

        orderDTO.setOrderDetailList(orderDetailList);

        // 借用账号
//        orderDTO.setBuyerOpenid("oTgZpwTykQPhdjiI8rWYEgXjWhI8");

        return orderDTO;

    }
}
