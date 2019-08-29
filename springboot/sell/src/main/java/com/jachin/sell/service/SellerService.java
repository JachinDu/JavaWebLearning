package com.jachin.sell.service;

import com.jachin.sell.entity.SellerInfo;

/**
 * @description: 卖家端
 * @Author: JachinDo
 * @Date: 2019/08/27 14:34
 */

public interface SellerService {

    /**
     * 通过openid查询卖家信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
