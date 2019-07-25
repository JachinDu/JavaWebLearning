package com.jachin.sell.dao;

import com.jachin.sell.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {

    @Autowired
    private ProductCategoryDao dao;

    @Test
    public void findOneTest() {
       ProductCategory productCategory = dao.findById(1).get();
        System.out.println(productCategory);
    }

    @Test
    public void saveTest() {
        ProductCategory productCategory = dao.findById(2).get();
        productCategory.setCategoryType(102);
        dao.save(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(2, 3, 102);
        List<ProductCategory> result = dao.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }

}