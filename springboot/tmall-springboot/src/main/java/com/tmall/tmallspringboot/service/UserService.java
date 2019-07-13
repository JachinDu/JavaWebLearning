package com.tmall.tmallspringboot.service;

import com.tmall.tmallspringboot.dao.UserDao;
import com.tmall.tmallspringboot.pojo.User;
import com.tmall.tmallspringboot.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public Page4Navigator<User> list(int start, int size, int navigatePages) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, size, sort);
        Page pageFromJPA =userDao.findAll(pageable);
        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }

    public boolean isExist(String name) {
        User user = getByName(name);
        return null!=user;
    }
    public User getByName(String name) {
        return userDao.findByName(name);
    }
    public void add(User user) {
        userDao.save(user);
    }

    public User get(String name, String password) {
        return userDao.getByNameAndPassword(name,password);
    }

}
