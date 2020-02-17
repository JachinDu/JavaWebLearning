package com.jachincloud.order.controller;

import com.jachincloud.order.client.ProductClient;
import com.jachincloud.order.dataobject.ProductInfo;
import com.jachincloud.order.dto.CartDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/09/12 17:06
 */
@RestController
@Slf4j
public class ClientController {

    @Autowired
    private ProductClient productClient;


    @GetMapping("/getProductList")
    public String getProductList() {
        List<ProductInfo> productInfoList = productClient.listForOrder(Arrays.asList("1"));
        log.info("response={}", productInfoList);
        return "ok";
    }

    @GetMapping("/decreaseStock")
    public String productDecreaseStock() {
        productClient.decreaseStock(Arrays.asList(new CartDTO("1566810298406637837", 3)));
        return "ok";
    }
}
