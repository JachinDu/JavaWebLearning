package com.jachin.sell.dao;

import com.jachin.sell.entity.OrderDetail;
import org.aspectj.weaver.ast.Or;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDaoTest {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("14");
        orderDetail.setOrderId("1111");
        orderDetail.setProductIcon("http://kkkkk");
        orderDetail.setProductId("11123");
        orderDetail.setProductName("皮皮虾");
        orderDetail.setProductPrice(new BigDecimal(1.3));
        orderDetail.setProductQuantity(2);

        OrderDetail result = orderDetailDao.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetailList = orderDetailDao.findByOrderId("1111");
        Assert.assertNotEquals(0, orderDetailList.size());

    }
}