package b_api;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestApi {
    public static void main(String[] args) {

        //1.创建数据源（连接池）dbcp
        BasicDataSource dataSource = new BasicDataSource();
        //基本四项
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_day02");
        dataSource.setUsername("root");
        dataSource.setPassword("5774857");


        //2.创建模版
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        //或者直接这样创建
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //3.通过api操作
        jdbcTemplate.update("insert into t_user(username,password) value(?,?);",
                "tom", "998");

    }
}
