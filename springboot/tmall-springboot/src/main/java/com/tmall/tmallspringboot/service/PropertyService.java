package com.tmall.tmallspringboot.service;


import com.tmall.tmallspringboot.dao.PropertyDao;
import com.tmall.tmallspringboot.pojo.Category;
import com.tmall.tmallspringboot.pojo.Property;
import com.tmall.tmallspringboot.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    @Autowired
    PropertyDao propertyDao;
    @Autowired
    CategoryService categoryService;

    public void add(Property property) {
        propertyDao.save(property);
    }

    public void delete(Integer id) {
        propertyDao.deleteById(id);
    }

    public Property get(Integer id) {
        return propertyDao.findById(id).get();
    }

    public void update(Property property) {
        propertyDao.save(property);
    }

    public Page4Navigator<Property> list(int cid, int start, int size, int navigatePages) {
        Category category = categoryService.get(cid);
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, size, sort);

        Page<Property> pageFromJPA = propertyDao.findByCategory(category,pageable);
        return new Page4Navigator<>(pageFromJPA, navigatePages);

    }

    // 通过分类获取所有属性集合
    public List<Property> listByCategory(Category category){
        return propertyDao.findByCategory(category);
    }


}
