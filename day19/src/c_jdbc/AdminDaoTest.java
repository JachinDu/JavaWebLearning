package c_jdbc;

import org.junit.Test;

import java.util.List;

public class AdminDaoTest {
    @Test
    public void testUpdate() {
        AdminDao adminDao = new AdminDao();
        //adminDao.delete(9);
        //adminDao.save(new Admin());
//        List<Admin> list = adminDao.getAll();
        Admin admin = adminDao.findById(100);
        System.out.println(admin);
    }

}
