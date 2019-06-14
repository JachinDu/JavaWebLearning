package mybatis.test;

import mybatis.bean.Employee;
import mybatis.dao.EmployeeMapper;
import mybatis.dao.EmployeeMapperPlus;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisCacheTest {
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    /*
     * 一级缓存
     * */
    @Test
    public void testFirstLevelCache() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
        Employee emp1 = mapper.getEmpById(1);
        System.out.println(emp1);

        Employee emp2 = mapper.getEmpById(1);
        System.out.println(emp2);

        openSession.close();
    }

    /*
     * 二级缓存
     * */
    @Test
    public void testSecondLevelCache() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        SqlSession openSession2 = sqlSessionFactory.openSession();


        EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
        EmployeeMapper mapper2 = openSession2.getMapper(EmployeeMapper.class);

        Employee employee1 = mapper.getEmpById(1);
        System.out.println(employee1);
        openSession.close();

        Employee employee2 = mapper2.getEmpById(1);
        System.out.println(employee1);
        openSession2.close();
    }
}
