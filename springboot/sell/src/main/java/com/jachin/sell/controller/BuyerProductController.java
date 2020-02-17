package com.jachin.sell.controller;

import com.jachin.sell.VO.ProductInfoVO;
import com.jachin.sell.VO.ProductVO;
import com.jachin.sell.VO.ResultVO;
import com.jachin.sell.entity.ProductCategory;
import com.jachin.sell.entity.ProductInfo;
import com.jachin.sell.enums.ProductStatusEnum;
import com.jachin.sell.service.CategoryService;
import com.jachin.sell.service.ProductService;
import com.jachin.sell.utils.ResultVOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @description: 买家商品
 * @Author: JachinDo
 * @Date: 2019/07/17 18:29
 */

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
//    @Cacheable(cacheNames = "product",key = "123")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "2") Integer size,
                             Map<String,Object> map) {
        // 1. 查询所有上架商品
        Pageable pageable = PageRequest.of(page-1, size);
        Page<ProductInfo> productInfoList = productService.findAll(pageable);

        // 2. 查询上架商品的类目(一次性查询)
        // 传统做法
//        List<Integer> categoryTypeList = new ArrayList<>();
//        for (ProductInfo productInfo : productInfoList) {
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        // 精简方法(lambda表达式java8)
//        List<Integer> categoryTypeList = productInfoList.stream()
//                .map(e -> e.getCategoryType())
//                .collect(Collectors.toList());
//        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);


        // 3. 数据拼装(前端文档中的数据输出格式)
//        List<ProductVO> productVOList = new ArrayList<>();
//        for (ProductCategory productCategory : productCategoryList) {
//            ProductVO productVO = new ProductVO();
//            productVO.setCategoryType(productCategory.getCategoryType());
//            productVO.setCategoryName(productCategory.getCategoryName());
//
//            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
//            for (ProductInfo productInfo : productInfoList) {
//                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
//                    ProductInfoVO productInfoVO = new ProductInfoVO();
//                    // 将productInfo的属性拷贝到productInfoVO中,省去大量的set
//                    BeanUtils.copyProperties(productInfo,productInfoVO);
//                    productInfoVOList.add(productInfoVO);
//                }
//            }
//            productVO.setProductInfoVOList(productInfoVOList);
//            productVOList.add(productVO);

//        }
        map.put("productInfoList",productInfoList);
        map.put("currentPage",page);
        map.put("size",size);
//        return ResultVOUtils.success(productVOList);
        return new ModelAndView("buyer_product/list", map);
    }


}
