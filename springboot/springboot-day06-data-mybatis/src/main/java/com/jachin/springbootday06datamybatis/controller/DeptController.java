package com.jachin.springbootday06datamybatis.controller;

import com.jachin.springbootday06datamybatis.bean.Department;
import com.jachin.springbootday06datamybatis.bean.Employee;
import com.jachin.springbootday06datamybatis.mapper.DepartmentMapper;
import com.jachin.springbootday06datamybatis.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id) {
        return departmentMapper.getDeptById(id);
    }


    @GetMapping("/dept")  //这里不用{}了，因为要封装对象，直接在url用？加参数即可自动封装
    public Department insertDept(Department department) {
        departmentMapper.insertDept(department);
        return department;
    }

    @GetMapping("/emp/{id}")
    public Employee getEmpById(@PathVariable("id") Integer id) {
        return employeeMapper.getEmpById(id);

    }
}
