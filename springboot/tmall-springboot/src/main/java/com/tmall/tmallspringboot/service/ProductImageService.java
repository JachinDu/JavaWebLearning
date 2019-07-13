package com.tmall.tmallspringboot.service;

import com.tmall.tmallspringboot.dao.ProductImageDAO;
import com.tmall.tmallspringboot.pojo.OrderItem;
import com.tmall.tmallspringboot.pojo.Product;
import com.tmall.tmallspringboot.pojo.ProductImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImageService {

    public static final String type_single = "single";
    public static final String type_detail = "detail";

    @Autowired
    ProductImageDAO productImageDAO;
    @Autowired
    ProductService productService;

    public void add(ProductImage bean) {
        productImageDAO.save(bean);
    }

    public void delete(Integer id) {
        productImageDAO.deleteById(id);
    }

    public ProductImage get(Integer id) {
        return productImageDAO.findById(id).get();
    }

    // 查出该产品的所有单一图片
    public List<ProductImage> listSingleProductImages(Product product) {
        return productImageDAO.findByProductAndTypeOrderByIdDesc(product, type_single);
    }

    // 查出该产品的所有细节图片
    public List<ProductImage> listDetailProductImages(Product product) {
        return productImageDAO.findByProductAndTypeOrderByIdDesc(product, type_detail);
    }


    // 给产品设置封面图
    // 注意区别setFirstProdutImage(Product product)，和setFirstProductImage（这个是product的set函数）
    public void setFirstProdutImage(Product product) {
        List<ProductImage> singleImages = listSingleProductImages(product);
        if (!singleImages.isEmpty()) {
            product.setFirstProductImage(singleImages.get(0));
        } else {
            // 这样做是考虑到产品还没有来得及设置图片，但是在订单后台管理里查看订单项的对应产品图片。
            product.setFirstProductImage(new ProductImage());

        }
    }

    // 给多个产品设置封面图
    public void setFirstProductImages(List<Product> products) {
        for (Product product : products) {
            setFirstProdutImage(product);
        }
    }

    public void setFirstProdutImagesOnOrderItems(List<OrderItem> ois) {
        for (OrderItem orderItem : ois) {
            setFirstProdutImage(orderItem.getProduct());
        }
    }

}
