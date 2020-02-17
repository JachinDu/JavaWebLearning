package com.jachincloud.product.client;

import com.jachincloud.product.common.DecreaseStockInput;
import com.jachincloud.product.common.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2020/01/04 19:17
 */
@FeignClient(name = "product")
public interface ProductClient {
    /**
     * 获取商品列表（给订单服务用的）
     *
     * @param productIdList
     * @return
     */
    @PostMapping("/listForOrder")
    List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);


    @PostMapping("/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);
}
