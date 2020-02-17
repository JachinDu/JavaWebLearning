package com.jachincloud.order.converter;


import com.jachincloud.order.dataobject.OrderMaster;
import com.jachincloud.order.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/07/22 15:05
 */

public class OrderMaster2OrderConverter {

    public static OrderDTO convert(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasters) {
        return orderMasters.stream().map(e ->
                convert(e)
        ).collect(Collectors.toList());
    }


}
