package com.jachincloud.user.service.impl;

import com.jachincloud.user.entity.UserInfo;
import com.jachincloud.user.repository.UserInfoRepository;
import com.jachincloud.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2020/01/07 16:45
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoRepository repository;

    /**
     * 通过openid查询用户信息
     * @param openid
     * @return
     */
    @Override
    public UserInfo findByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }

}
