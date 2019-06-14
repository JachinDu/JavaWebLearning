package c_jdbc;

import java.util.List;

public class AdminDao extends BaseDao{
    public void delete(int id) {
        String sql = "delete from admin where id=?";
        Object[] paramsValues = {id};
        super.update(sql,paramsValues);
    }

    public void save(Admin admin) {
        String sql = "insert into admin (userName,password) values (?,?)";
        Object[] paramsValues = {admin.getUserName(), admin.getPassword()};
        super.update(sql,paramsValues);
    }

    public List<Admin> getAll() {
        String sql = "select * from admin";
        List<Admin> list = super.query(sql, null, Admin.class);
        return list;
    }

    public Admin findById(int id) {
        String sql = "select * from admin where id=?";
        List<Admin> list = super.query(sql, new Object[] {id}, Admin.class);
        return list!=null&&list.size()>0 ? list.get(0) : null;
    }
}
