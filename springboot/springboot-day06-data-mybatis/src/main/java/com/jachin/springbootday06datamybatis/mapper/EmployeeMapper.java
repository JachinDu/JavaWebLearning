package com.jachin.springbootday06datamybatis.mapper;


import com.jachin.springbootday06datamybatis.bean.Employee;

//一定要使用@Mapper或在启动类上@MapperScan
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public int insertEmp(Employee employee);
}
