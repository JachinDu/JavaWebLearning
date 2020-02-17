package com.jachincloud.product.service;

import com.jachincloud.product.dataobject.ProductCategory;

import java.util.List;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/09/12 15:31
 */

public interface CategoryService {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
