package com.jachin.springbootday03restfulcrud.controller;


import com.jachin.springbootday03restfulcrud.dao.DepartmentDao;
import com.jachin.springbootday03restfulcrud.dao.EmployeeDao;
import com.jachin.springbootday03restfulcrud.entities.Department;
import com.jachin.springbootday03restfulcrud.entities.Employee;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/*
* 员工处理
* */
@Controller
public class EmpLoyeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工，返回列表页面
    @GetMapping("/emps")
    public String list(Model model) {

        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps", employees);
        //因为默认只拼到template
        return "emp/list";
    }


    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        //来到添加页面,查出所有部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }


    //员工添加
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        //来到员工列表页面

        System.out.println("保存的员工："+employee);
        //保存员工
        employeeDao.save(employee);
        //不能直接return "/emps"，因为默认会路径解析，这样就到不了/emps请求了
        //使用forward和redirect
        //  /代表当前项目路径
        return "redirect:/emps";
    }

    //修改员工页面,查出当前员工，回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model) {

        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        //页面要显示所有部门列表，因为要修改
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);

        //回到修改页面（add是修改添加二合一页面）
        return "emp/add";
    }

    //员工修改:需要提交员工id
    @PutMapping("/emp/{id}")
    public String updateEmployee(Employee employee) {

        System.out.println("修改员工数据："+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
