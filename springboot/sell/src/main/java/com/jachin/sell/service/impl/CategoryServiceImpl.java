package com.jachin.sell.service.impl;

import com.jachin.sell.dao.ProductCategoryDao;
import com.jachin.sell.entity.ProductCategory;
import com.jachin.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    ProductCategoryDao dao;

    @Override
    public ProductCategory findById(Integer categoryId) {
        return dao.findById(categoryId).get();
    }

    @Override
    public List<ProductCategory> findAll() {
        return dao.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return dao.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return dao.save(productCategory);
    }
}
