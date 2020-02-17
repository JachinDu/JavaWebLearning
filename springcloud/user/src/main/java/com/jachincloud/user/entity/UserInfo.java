package com.jachincloud.user.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2020/01/07 16:38
 */
@Entity
@Data
public class UserInfo {

    @Id
    private String id;

    private String username;

    private String password;

    private String openid;

    private Integer role;
}
