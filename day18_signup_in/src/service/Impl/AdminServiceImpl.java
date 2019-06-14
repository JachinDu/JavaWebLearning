package service.Impl;

import Dao.IAdminDao;
import Dao.Impl.AdminDaoImpl;
import Dao.Impl.AdminDaoImpl_DbUtils;
import entity.Admin;
import exception.UserExistsException;
import service.IAdminService;

/*
* 业务逻辑层，实现类
* */
public class AdminServiceImpl implements IAdminService {
    //private IAdminDao adminDao = new AdminDaoImpl();
    private IAdminDao adminDao = new AdminDaoImpl_DbUtils();
            ;
    @Override
    public void register(Admin admin) throws UserExistsException{
        try {
            boolean flag = adminDao.userExists(admin.getUserName());

            if (flag) {
                throw new UserExistsException("用户名已被注册！");
            }
            adminDao.save(admin);
        } catch (UserExistsException e) {
            throw e;
        } catch (Exception e1) {
            throw new RuntimeException(e1);
        }
    }

    @Override
    public Admin login(Admin admin) {
        try {
            return adminDao.findByNameAndPwd(admin);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
