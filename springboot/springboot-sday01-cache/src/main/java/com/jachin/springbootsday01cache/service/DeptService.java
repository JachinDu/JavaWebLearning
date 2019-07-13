package com.jachin.springbootsday01cache.service;

import com.jachin.springbootsday01cache.bean.Department;
import com.jachin.springbootsday01cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = "dept",cacheManager = "deptCacheManager")
@Service
public class DeptService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Cacheable
    public Department getDeptById(Integer id) {
        Department deptById = departmentMapper.getDeptById(id);
        return deptById;
    }

}
