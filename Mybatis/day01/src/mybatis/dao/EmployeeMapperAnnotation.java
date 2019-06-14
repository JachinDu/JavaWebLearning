package mybatis.dao;

import mybatis.bean.Employee;
import org.apache.ibatis.annotations.Select;

public interface EmployeeMapperAnnotation {
//    这里是查询注解，若是插入等可选Insert等注解
    @Select("select * from tb_employee where id=#{id}")
    public Employee getEmpById(Integer id);

}
