package com.jachin.sell.dao;

import com.jachin.sell.entity.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/08/27 14:29
 */

public interface SellerInfoDao extends JpaRepository<SellerInfo, String> {

    SellerInfo findByOpenid(String openid);
}
