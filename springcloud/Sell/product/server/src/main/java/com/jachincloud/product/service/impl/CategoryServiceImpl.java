package com.jachincloud.product.service.impl;

import com.jachincloud.product.dataobject.ProductCategory;
import com.jachincloud.product.repository.ProductCategoryRepository;
import com.jachincloud.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/09/12 15:33
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }
}
