package com.tmall.tmallspringboot.web;

import com.tmall.tmallspringboot.pojo.Product;
import com.tmall.tmallspringboot.pojo.ProductImage;
import com.tmall.tmallspringboot.service.CategoryService;
import com.tmall.tmallspringboot.service.ProductImageService;
import com.tmall.tmallspringboot.service.ProductService;
import com.tmall.tmallspringboot.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductImageController {

    @Autowired
    ProductService productService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/products/{pid}/productImages")
    public List<ProductImage> list(@RequestParam("type") String type,
                                   @PathVariable("pid") Integer pid) {
        Product product = productService.get(pid);
        if (ProductImageService.type_single.equals(type)) {
            List<ProductImage> singels = productImageService.listSingleProductImages(product);
            return singels;
        } else if (ProductImageService.type_detail.equals(type)) {
            List<ProductImage> details = productImageService.listDetailProductImages(product);
            return details;
        } else {
            return new ArrayList<>();
        }
    }

    @PostMapping("/productImages")
    public Object add(@RequestParam("pid") Integer pid, @RequestParam("type") String type,
                      MultipartFile image, HttpServletRequest request) {


        ProductImage bean = new ProductImage();
        Product product = productService.get(pid);
        bean.setProduct(product);
        bean.setType(type);

        // 1.先将信息存入数据库
        productImageService.add(bean);

        // 2.再存文件
        saveImageFile(bean,image,request);
        return bean;
    }

    public void saveImageFile(ProductImage bean, MultipartFile image, HttpServletRequest request) {

        // 拼路径
        String folder = "img/";
        if (ProductImageService.type_single.equals(bean.getType())) {
            folder += "productSingle";
        } else {
            folder += "productDetail";
        }

        // 找对应文件
        File imageFolder = new File(request.getServletContext().getRealPath(folder));
        File file = new File(imageFolder, bean.getId() + ".jpg");
        String fileName = file.getName();
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            image.transferTo(file);
            BufferedImage img = ImageUtil.change2jpg(file);
            ImageIO.write(img, "jpg", file);
        } catch (IOException e) {
            e.printStackTrace();
        }


        // 产品单一图片做特殊处理
        if (ProductImageService.type_single.equals(bean.getType())) {
            String imageFolder_small = request.getServletContext().getRealPath("img/productSingle_small");
            String imageFolder_middle = request.getServletContext().getRealPath("img/productSingle_middle");
            File f_small = new File(imageFolder_small, fileName);
            File f_middle = new File(imageFolder_middle, fileName);

            f_small.getParentFile().mkdirs();
            f_middle.getParentFile().mkdirs();
            // 将上传的图片分别压缩后再存到两个位置
            ImageUtil.resizeImage(file, 56, 56, f_small);
            ImageUtil.resizeImage(file, 217, 190, f_middle);
        }
    }

    @DeleteMapping("/productImages/{id}")
    public String delete(@PathVariable("id") Integer id, HttpServletRequest request) {
        // 1. 从数据库删除图片信息
        ProductImage bean = productImageService.get(id);
        productImageService.delete(id);
        // 2. 从文件夹中删除图片文件
        String folder = "img/";
        if (ProductImageService.type_single.equals(bean.getType())) {
            folder += "productSingle";
        } else {
            folder += "productDetail";
        }

        File imageFolder = new File(request.getServletContext().getRealPath(folder));
        File file =  new File(imageFolder, bean.getId() + ".jpg");
        String fileName = file.getName();
        file.delete();

        // 产品单个图片的特殊处理后图片也要删除
        if (ProductImageService.type_single.equals(bean.getType())) {
            String imageFolder_small= request.getServletContext().getRealPath("img/productSingle_small");
            String imageFolder_middle= request.getServletContext().getRealPath("img/productSingle_middle");
            File f_small = new File(imageFolder_small, fileName);
            File f_middle = new File(imageFolder_middle, fileName);
            f_small.delete();
            f_middle.delete();
        }
        return null;
    }
}
