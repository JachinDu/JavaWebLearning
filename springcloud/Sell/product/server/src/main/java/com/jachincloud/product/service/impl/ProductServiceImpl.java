package com.jachincloud.product.service.impl;

import com.jachincloud.product.common.DecreaseStockInput;
import com.jachincloud.product.common.ProductInfoOutput;
import com.jachincloud.product.dataobject.ProductInfo;
import com.jachincloud.product.enums.ProductStatusEnum;
import com.jachincloud.product.enums.ResultEnum;
import com.jachincloud.product.exception.ProductException;
import com.jachincloud.product.repository.ProductInfoRepository;
import com.jachincloud.product.service.ProductService;
import com.jachincloud.product.utils.JsonUtil;
import com.rabbitmq.tools.json.JSONUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/09/12 15:26
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfoOutput> findList(List<String> productIdList) {
        return repository.findByProductIdIn(productIdList).stream()
                .map(e -> {
                    ProductInfoOutput output = new ProductInfoOutput();
                    BeanUtils.copyProperties(e, output);
                    return output;
                })
                .collect(Collectors.toList());
    }

    //    @Override
//
//    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
//        for (DecreaseStockInput decreaseStockInput : decreaseStockInputList) {
//            Optional<ProductInfo> productInfoOptional = repository.findById(decreaseStockInput.getProductId());
//            // 判断商品是否存在
//            if (!productInfoOptional.isPresent()) {
//                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
//            }
//
//            // 减库存
//            ProductInfo productInfo = productInfoOptional.get();
//            Integer result = productInfo.getProductStock() - decreaseStockInput.getProductQuantity();
//            // 库存是否足够
//            if (result < 0) {
//                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
//            }
//
//            // 更新库存
//            productInfo.setProductStock(result);
//            repository.save(productInfo);
//            ProductInfoOutput productInfoOutput = new ProductInfoOutput();
//            BeanUtils.copyProperties(productInfo,productInfoOutput);
//
//            // 发送mq消息, 这里要是直接这样的话，可能第一个商品发了消息，第二个商品抛了异常，数据回滚，连第一个商品也回滚了，但
//            // 没法回滚发出去的消息。
//            amqpTemplate.convertAndSend("productInfo", JsonUtil.toJson(productInfoOutput));
//        }
//    }

    @Transactional
    public List<ProductInfoOutput> decreaseStockProcess(List<DecreaseStockInput> decreaseStockInputList) {

        List<ProductInfoOutput> productInfoOutputs = new ArrayList<>();

        for (DecreaseStockInput decreaseStockInput : decreaseStockInputList) {
            Optional<ProductInfo> productInfoOptional = repository.findById(decreaseStockInput.getProductId());
            // 判断商品是否存在
            if (!productInfoOptional.isPresent()) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            // 减库存
            ProductInfo productInfo = productInfoOptional.get();
            Integer result = productInfo.getProductStock() - decreaseStockInput.getProductQuantity();
            // 库存是否足够
            if (result < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            // 更新库存
            productInfo.setProductStock(result);
            repository.save(productInfo);
            ProductInfoOutput productInfoOutput = new ProductInfoOutput();
            BeanUtils.copyProperties(productInfo, productInfoOutput);

            productInfoOutputs.add(productInfoOutput);
        }
        return productInfoOutputs;
    }

    @Override
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
        List<ProductInfoOutput> productInfoOutputs = decreaseStockProcess(decreaseStockInputList);
        amqpTemplate.convertAndSend("productInfo", JsonUtil.toJson(productInfoOutputs));
    }
}
