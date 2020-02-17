package com.jachincloud.order.repository;

import com.jachincloud.order.OrderApplicationTests;
import com.jachincloud.order.dataobject.OrderMaster;
import com.jachincloud.order.enums.OrderStatusEnum;
import com.jachincloud.order.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void testSave() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("4422223");
        orderMaster.setBuyerName("cloud");
        orderMaster.setBuyerPhone("13222222222");
        orderMaster.setBuyerAddress("慕课网");
        orderMaster.setBuyerOpenid("110110");
        orderMaster.setOrderAmount(new BigDecimal(2.34));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }
}