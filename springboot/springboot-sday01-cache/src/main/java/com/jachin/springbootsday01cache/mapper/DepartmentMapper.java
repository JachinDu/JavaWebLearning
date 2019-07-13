package com.jachin.springbootsday01cache.mapper;


import com.jachin.springbootsday01cache.bean.Department;
import org.apache.ibatis.annotations.Select;

public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    Department getDeptById(Integer id);
}
