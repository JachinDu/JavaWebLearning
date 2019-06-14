package mybatis.dao;

import mybatis.bean.Employee;

import java.util.List;

public interface EmployeeMapperPlus {
    public Employee getEmpById(Integer id);

    public Employee getEmpAndDept(Integer id);

    //按部门id查出所有员工
    public List<Employee> getEmpsByDeptId(Integer deptId);

}
