package dao.impl;

import dao.IEmployeeDao;
import entity.Employee;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JdbcUtils;
import utils.PageBean;

import java.sql.SQLException;
import java.util.List;

/*
* 数据访问层实现
* */
public class EmployeeDao implements IEmployeeDao {
    @Override
    public void getAll(PageBean pb) {


        //1.查询总记录数；设置到pb对象中
        int totalCount = this.getTotalCount();
        pb.setTotalCount(totalCount);

        if (pb.getCurrentPage() <= 0) {
            pb.setCurrentPage(1);
        } else if (pb.getCurrentPage() > pb.getTotalPage()) {
            pb.setCurrentPage(pb.getTotalPage());
        }

        //2、获取当前页：计算查询的起始行和返回的行数
        int currentPage = pb.getCurrentPage();
        int index = (currentPage-1)*pb.getCurrentPage();
        int count = pb.getPageCount();

        //3.分页查询数据，把查询到到数据设置到pb对象中
        String sql = "select * from employee limit ?,?";
        //得到Queryrunner对象
        QueryRunner qr = JdbcUtils.getQueryRunner();
        //根据当前页，查询一页数据
        try {
            List<Employee> pageData = qr.query(sql,new BeanListHandler<Employee>(Employee.class),index,count);
            //设置到pb对象中
            pb.setPageData(pageData);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getTotalCount() {
        String sql = "select count(*) from employee";
        QueryRunner qr = JdbcUtils.getQueryRunner();
        try {
            Long count = qr.query(sql, new ScalarHandler<Long>());
            return count.intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
