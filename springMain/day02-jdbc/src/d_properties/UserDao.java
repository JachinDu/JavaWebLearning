package d_properties;

import a_domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class UserDao extends JdbcDaoSupport {

    public void update(User user) {
        String sql = "update t_user set username=?,password=? where id=?";
        Object[] args = {user.getUsername(),user.getPassword(),user.getId()};

        this.getJdbcTemplate().update(sql, args);
    }

    /*
     * 查询所有
     * */
    public List<User> findAll() {
        return this.getJdbcTemplate().query("select * from t_user",new BeanPropertyRowMapper<User>(User.class));
    }
}
