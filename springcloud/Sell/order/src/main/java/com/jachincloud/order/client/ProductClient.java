package com.jachincloud.order.client;

import com.jachincloud.order.dataobject.ProductInfo;
import com.jachincloud.order.dto.CartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/09/16 21:56
 */
@FeignClient(name = "product", fallback = ProductClient.ProductClientFallback.class)
public interface ProductClient {

    @PostMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(@RequestBody List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<CartDTO> cartDTOList);

    @Component // 勿忘
    static class ProductClientFallback implements ProductClient{

        @Override
        public List<ProductInfo> listForOrder(List<String> productIdList) {
            return null;
        }

        @Override
        public void decreaseStock(List<CartDTO> cartDTOList) {

        }
    }

}
