package com.jachin.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/07/25 21:04
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {


    // 公众平台id
    private String mpAppId;
    // 公众平台密钥
    private String mpAppSecret;

    // 开放平台id
    private String openAppId;
    // 开放平台密钥
    private String openAppSecret;
    // 商户号
    private String mchId;
    // 商户密钥
    private String mchKey;
    // 商户证书路径
    private String keyPath;
    // 微信支付异步通知地址
    private String notifyUrl;
}
