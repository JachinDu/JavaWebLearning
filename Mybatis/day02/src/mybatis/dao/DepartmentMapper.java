package mybatis.dao;

import mybatis.bean.Department;

public interface DepartmentMapper {
    public Department getDeptById(Integer id);

    //可以查出部门中的所有员工
    public Department getDeptByIdPlus(Integer id);

    //分步查询
    public Department getDeptByIdStep(Integer id);
}
