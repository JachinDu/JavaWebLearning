package c_dbcp;

import a_domain.User;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    private JdbcTemplate jdbcTemplate;
    //jdbc模版又spring注入（setter注入）
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void update(User user) {
        String sql = "update t_user set username=?,password=? where id=?";
        Object[] args = {user.getUsername(),user.getPassword(),user.getId()};
        jdbcTemplate.update(sql, args);
    }
}
