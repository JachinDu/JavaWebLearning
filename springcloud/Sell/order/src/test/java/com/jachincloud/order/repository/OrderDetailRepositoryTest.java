package com.jachincloud.order.repository;

import com.jachincloud.order.OrderApplicationTests;
import com.jachincloud.order.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@Component
public class OrderDetailRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("14");
        orderDetail.setOrderId("1111");
        orderDetail.setProductIcon("http://kkkkk");
        orderDetail.setProductId("11123");
        orderDetail.setProductName("皮皮333虾");
        orderDetail.setProductPrice(new BigDecimal(1.3));
        orderDetail.setProductQuantity(2);

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

}