package service;

import entity.Admin;
import exception.UserExistsException;

/*
* 业务逻辑层，接口设计
* */
public interface IAdminService {
    //注册
    void register(Admin admin) throws UserExistsException;

    //登陆
    Admin login(Admin admin);
}
