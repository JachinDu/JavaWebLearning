package com.jachin.sell.service.impl;

import com.jachin.sell.dao.SellerInfoDao;
import com.jachin.sell.entity.SellerInfo;
import com.jachin.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/08/27 14:35
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoDao sellerInfoDao;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return sellerInfoDao.findByOpenid(openid);
    }

}
