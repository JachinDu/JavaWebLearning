package mybatis.dao;

import mybatis.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    public List<Employee> getEmpsByName(String name);

    public Employee getEmpByIdAndName(@Param("id")Integer id, @Param("last_name") String name);
    public Employee getEmpById(Integer id);

    public void addEmp(Employee employee);

    public boolean updateEmp(Employee employee);

    public void deleteEmpById(Integer id);
}
