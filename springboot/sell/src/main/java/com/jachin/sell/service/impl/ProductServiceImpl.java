package com.jachin.sell.service.impl;

import com.jachin.sell.dao.ProductInfoDao;
import com.jachin.sell.dto.CartDTO;
import com.jachin.sell.entity.ProductInfo;
import com.jachin.sell.enums.ProductStatusEnum;
import com.jachin.sell.enums.ResultEnum;
import com.jachin.sell.exception.SellException;
import com.jachin.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoDao dao;

    @Override
    public ProductInfo findById(String productId) {
        return dao.findById(productId).get();
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return dao.findByProductStatus(ProductStatusEnum.UP.getState());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {

        return dao.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {

        return dao.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = dao.findById(cartDTO.getProductId()).get();
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            dao.save(productInfo);
        }

    }

    @Override
    @Transactional // 要么全部成功，要么全部不成功，因为这是一笔订单的所有商品
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = dao.findById(cartDTO.getProductId()).get();
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            // 减库存
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            // 更新库存
            productInfo.setProductStock(result);
            dao.save(productInfo);
        }
    }
}
