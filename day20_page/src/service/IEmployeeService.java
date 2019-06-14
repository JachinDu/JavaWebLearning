package service;

import entity.Employee;
import utils.PageBean;

/*
* 业务逻辑接口设计
* */
public interface IEmployeeService {
    /*
     * 分页查询数据
     * */
    public void getAll(PageBean<Employee> pb);
}
