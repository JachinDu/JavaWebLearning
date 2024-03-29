package com.jachin.springbootsday01cache.controller;


import com.jachin.springbootsday01cache.bean.Employee;
import com.jachin.springbootsday01cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id) {
        Employee emp = employeeService.getEmp(id);
        return emp;

    }


    @GetMapping("/emp")
    public Employee update(Employee employee) {
        Employee employee1 = employeeService.updateEmp(employee);
        return employee1;
    }


    @GetMapping("delEmp")
    public String deleteEmp(Integer id) {
        employeeService.deleteEmp(id);
        return "success";
    }

    @GetMapping("/emp/lastname/{lastName}")
    public Employee getEmpByLastname(@PathVariable("lastName") String lastName) {
        return employeeService.getEmpByLastName(lastName);
    }
}
