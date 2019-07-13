package com.tmall.tmallspringboot.web;


import com.tmall.tmallspringboot.pojo.Category;
import com.tmall.tmallspringboot.service.CategoryService;
import com.tmall.tmallspringboot.util.ImageUtil;
import com.tmall.tmallspringboot.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/*
* 这是专门提供RESTFUL服务的controller
* */
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public Page4Navigator<Category> list(@RequestParam(value = "start",defaultValue = "0") int start,
                                         @RequestParam(value = "size",defaultValue = "5") int size) {
        start = start < 0?0:start;
        // 5表示导航条最多显示5个，如【3】【4】【5】【6】【7】
        Page4Navigator<Category> page = categoryService.list(start, size, 5);
        return page;
    }

    @PostMapping("/categories")
    public Object add(Category bean, MultipartFile image, HttpServletRequest request) throws IOException {
        categoryService.add(bean);
        saveOrUpdateImageFile(bean, image, request);
        return bean;
    }

    // 存储图片
    public void saveOrUpdateImageFile(Category bean, MultipartFile image, HttpServletRequest request) throws IOException {
        File imageFolder = new File(request.getServletContext().getRealPath("img/category"));
        // jpa save完后会将主键值返回更新我们都bean，所以这里getId不再为null
        File file = new File(imageFolder, bean.getId() + ".jpg");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        image.transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
    }

    @DeleteMapping("/categories/{id}")
    public String delete(@PathVariable("id") Integer id, HttpServletRequest request) {
        categoryService.delete(id);
        //        要先构造出这个文件对象才能执行删除！！
        File imageFolder = new File(request.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder, id + ".jpg");
        file.delete();
        return null;  //这里返回null就可以，因为@RestController会转换为空字符串，与前端页面判断是否为空字符串呼应
    }

    // 获取信息回显到编辑页面
    @GetMapping("/categories/{id}")
    public Category get(@PathVariable("id") Integer id) {
        Category category = categoryService.get(id);
        return category;
    }

    // 修改
    @PutMapping("/categories/{id}")
    public Object update(Category bean, MultipartFile image, HttpServletRequest request) throws IOException {
        categoryService.update(bean);
        if (image != null) {
            saveOrUpdateImageFile(bean,image,request);
        }
        return bean;
    }


}
