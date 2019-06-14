package mybatis.test;

import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;
import mybatis.bean.Department;
import mybatis.bean.Employee;
import mybatis.dao.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyBatisTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    /*
    * 1.根据xml配置文件（全局配置文件）创建一个SqlSessionFactory对象
    * */
    @Test
    public void test() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession实例,嗯干直接执行已经映射的sql语句
        SqlSession openSession = sqlSessionFactory.openSession();
        //参数1：sql唯一标识（namespace+id)
        //参数2：执行sql要用的参数
        try {
            Employee employee = openSession.selectOne("jiacheng.mybatis.EmployeeMapper.selectEmp", 1);
            System.out.println(employee);
        } finally {
            openSession.close();
        }

    }

    @Test
    public void test01() throws IOException {
        //1.获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //2.获取SqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();
        //3.获取接口的实现类对象
        //会为接口自动创建一个代理对象，代理对象去执行数据库操作
        EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
//        Employee employee = mapper.getEmpById(1);
//        Employee employee = mapper.getEmpByIdAndName(1,"jerry1");
        List<Employee> list = mapper.getEmpsByName("%e%");//模糊查询，查出名字中带e字母的
        for (Employee employee:list
             ) {
            System.out.println(employee);
        }
        openSession.close();

    }


    @Test
    public void test02() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        EmployeeMapperAnnotation mapper = openSession.getMapper(EmployeeMapperAnnotation.class);
        Employee employee = mapper.getEmpById(1);
        System.out.println(employee);
    }


    /*
    * 测试增删改
    * 1、mabatis允许增删改直接定义以下类型返回值(返回的是影响多少行）
    *       Integer Long Boolean
    * */
    @Test
    public void test03() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //1、该方式获取到的SqlSession不会自动提交数据
        SqlSession openSession = sqlSessionFactory.openSession(true);

        EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

        //测试添加
        Employee employee = new Employee(null,"jerry","jerry@guigu.com","1");
        mapper.addEmp(employee);
        System.out.println(employee.getId());

        //测试修改
//        Employee employee = new Employee(1,"jerry1","jerry22@guigu.com","0");
//        boolean updateEmp = mapper.updateEmp(employee);
//        System.out.println(updateEmp);

        //测试删除
//        mapper.deleteEmpById(2);

        //2、手动提交数据
//        openSession.commit();
    }

    @Test
    public void test05() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        EmployeeMapperPlus mapper = openSession.getMapper(EmployeeMapperPlus.class);
        Employee employee = mapper.getEmpById(1);
//        System.out.println(employee);
//        Employee emp = mapper.getEmpAndDept(1);
        System.out.println(employee.getLastName());
        System.out.println(employee.getDept());
        openSession.close();
    }


    @Test
    public void test06() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        DepartmentMapper departmentMapper = openSession.getMapper(DepartmentMapper.class);
        Department department = departmentMapper.getDeptByIdStep(1);
        System.out.println(department);
        System.out.println(department.getEmployees());
    }

    @Test
    public void testDynamicSql() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
        Employee employee = new Employee(1, "Admin", null, null);
        List<Employee> emps = mapper.getEmpsByConditionForeach(Arrays.asList(1,2,3));
        for (Employee emp : emps) {
            System.out.println(emp);
        }
//        mapper.updateEmp(employee);
//        openSession.commit();
        openSession.close();
    }

    @Test
    public void testBatchSave() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
        List<Employee> emps = new ArrayList<>();
        emps.add(new Employee(null, "smith", "smith@guigu.com", "1", new Department(1)));
        emps.add(new Employee(null, "alan", "alan@guigu.com", "0", new Department(1)));

        mapper.addEmps(emps);
        openSession.commit();
        openSession.close();
    }
}
