package com.tmall.tmallspringboot.service;


import com.tmall.tmallspringboot.dao.OrderItemDAO;
import com.tmall.tmallspringboot.pojo.Order;
import com.tmall.tmallspringboot.pojo.OrderItem;
import com.tmall.tmallspringboot.pojo.Product;
import com.tmall.tmallspringboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    OrderItemDAO orderItemDAO;
    @Autowired ProductImageService productImageService;

    public void fill(List<Order> orders) {
        for (Order order : orders) {
            fill(order);
        }
    }

    public void fill(Order order) {
        List<OrderItem> orderItems = listByOrder(order);
        double total = 0;
        int totalNumber = 0;
        for (OrderItem oi :orderItems) {
            // 计算总金额
            total+=oi.getNumber()*oi.getProduct().getPromotePrice();
            // 计算总数
            totalNumber+=oi.getNumber();
            // 显示产品图片
            productImageService.setFirstProdutImage(oi.getProduct());
        }
        // 注入属性值给Order的transient属性
        order.setTotal(total);
        order.setOrderItems(orderItems);
        order.setTotalNumber(totalNumber);
    }

    public List<OrderItem> listByOrder(Order order) {

        return orderItemDAO.findByOrderOrderByIdDesc(order);
    }

    public void update(OrderItem orderItem) {
        orderItemDAO.save(orderItem);
    }

    public void add(OrderItem orderItem) {
        orderItemDAO.save(orderItem);
    }
    public OrderItem get(int id) {
        return orderItemDAO.findById(id).get();
    }

    public void delete(int id) {
        orderItemDAO.deleteById(id);
    }


    // 获取产品销量
    public int getSaleCount(Product product) {
        List<OrderItem> ois =listByProduct(product);
        int result =0;
        for (OrderItem oi : ois) {
            if(null!=oi.getOrder()) {
                if(null!= oi.getOrder() && null!=oi.getOrder().getPayDate()) {
                    result+=oi.getNumber();
                }
            }
        }
        return result;
    }

    public List<OrderItem> listByProduct(Product product) {
        return orderItemDAO.findByProduct(product);
    }

    public List<OrderItem> listByUser(User user) {
        return orderItemDAO.findByUserAndOrderIsNull(user);
    }

}
