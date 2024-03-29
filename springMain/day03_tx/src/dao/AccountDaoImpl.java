package dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    @Override
    public void out(String outer, Integer money) {
        //注意sql语句的写法set money = money - ?
        this.getJdbcTemplate().update("update account set money = money - ? where username=?", money, outer);
    }

    @Override
    public void in(String inner, Integer money) {
        this.getJdbcTemplate().update("update account set money = money + ? where username=?", money, inner);

    }
}
