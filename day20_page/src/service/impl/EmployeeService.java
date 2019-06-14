package service.impl;

import dao.IEmployeeDao;
import dao.impl.EmployeeDao;
import entity.Employee;
import service.IEmployeeService;
import utils.PageBean;

/*
* 业务逻辑层，实现
* */
public class EmployeeService implements IEmployeeService {
    //创建Dao实例
    private IEmployeeDao employeeDao = new EmployeeDao();

    @Override
    public void getAll(PageBean<Employee> pb) {
        employeeDao.getAll(pb);
    }
}
