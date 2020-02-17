package com.jachincloud.user.repository;

import com.jachincloud.user.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2020/01/07 16:42
 */

public interface UserInfoRepository extends JpaRepository<UserInfo, String> {
    UserInfo findByOpenid(String openid);
}
