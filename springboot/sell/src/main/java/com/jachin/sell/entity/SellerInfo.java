package com.jachin.sell.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @description: 卖家信息实体类
 * @Author: JachinDo
 * @Date: 2019/08/27 14:28
 */
@Data
@Entity
public class SellerInfo {

    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;

}
