package com.jachincloud.product.controller;

import com.jachincloud.product.VO.ProductInfoVO;
import com.jachincloud.product.VO.ProductVO;
import com.jachincloud.product.VO.ResultVO;
import com.jachincloud.product.common.DecreaseStockInput;
import com.jachincloud.product.common.ProductInfoOutput;
import com.jachincloud.product.dataobject.ProductCategory;
import com.jachincloud.product.dataobject.ProductInfo;
import com.jachincloud.product.service.CategoryService;
import com.jachincloud.product.service.ProductService;
import com.jachincloud.product.utils.ResultVOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/09/12 15:07
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    /**
     * 1. 查询所有在架商品
     * 2. 获取类目列表
     * 3. 查询类目
     * 4. 构造数据
     */
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
//    @Cacheable(cacheNames = "product",key = "123")
    public ResultVO<ProductVO> list() {

        // 1. 查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        // 2. 查询上架商品的类目(一次性查询)
        // 传统做法
//        List<Integer> categoryTypeList = new ArrayList<>();
//        for (ProductInfo productInfo : productInfoList) {
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        // 精简方法(lambda表达式java8)
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);


        // 3. 数据拼装(前端文档中的数据输出格式)
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    // 将productInfo的属性拷贝到productInfoVO中,省去大量的set
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);

        }

        return ResultVOUtils.success(productVOList);
    }


    /**
     * 获取商品列表（给订单服务用的）
     *
     * @param productIdList
     * @return
     */
    @PostMapping("/listForOrder")
    public List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList) {
        return productService.findList(productIdList);
    }

    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList) {
        productService.decreaseStock(decreaseStockInputList);
    }
}
