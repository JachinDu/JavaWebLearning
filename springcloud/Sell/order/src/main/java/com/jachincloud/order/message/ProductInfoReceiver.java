package com.jachincloud.order.message;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jachincloud.order.dataobject.ProductInfo;
import com.jachincloud.order.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2020/01/04 19:56
 */
@Component
@Slf4j
public class ProductInfoReceiver {

    private static final String PRODUCT_STOCK_TEMPLATE = "product_stock_%s";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message) {
        // message --> ProductInfo
        List<ProductInfo> productInfoList = (List<ProductInfo>) JsonUtil.fromJson(message,
                new TypeReference<List<ProductInfo>>() {});
        log.info("从队列【{}】接收到消息：{}", "productInfo",productInfoList);

        // 存储到redis中
        for (ProductInfo productInfo : productInfoList) {
            stringRedisTemplate.opsForValue().set(String.format(PRODUCT_STOCK_TEMPLATE, productInfo.getProductId()),
                    String.valueOf(productInfo.getProductStock()));
        }


    }
}
