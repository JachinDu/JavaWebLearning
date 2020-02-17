package com.jachincloud.product.service;

import com.jachincloud.product.common.DecreaseStockInput;
import com.jachincloud.product.common.ProductInfoOutput;
import com.jachincloud.product.dataobject.ProductInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/09/12 15:25
 */

public interface ProductService {

    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表（订单服务用）
     *
     * @param productIdList
     * @return
     */
    List<ProductInfoOutput> findList(List<String> productIdList);

    /**
     * 扣库存
     *
     * @param cartDTOList
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}
