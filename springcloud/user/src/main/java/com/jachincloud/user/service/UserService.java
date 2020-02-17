package com.jachincloud.user.service;

import com.jachincloud.user.entity.UserInfo;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2020/01/07 16:43
 */

public interface UserService {
    /**
     * 通过openid查询用户信息
     * @param openid
     * @return
     */
    UserInfo findByOpenid(String openid);
}
