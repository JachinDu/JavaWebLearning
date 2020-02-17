package com.jachin.sell.aspect;

import com.jachin.sell.constant.CookieConstant;
import com.jachin.sell.constant.RedisConstant;
import com.jachin.sell.exception.SellException;
import com.jachin.sell.exception.SellerAuthorizeException;
import com.jachin.sell.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/08/27 16:58
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {
    @Autowired
    private StringRedisTemplate redisTemplate;


    @Pointcut("execution(public * com.jachin.sell.controller.Sell*.*(..))" +
    "&& !execution(public * com.jachin.sell.controller.SellerUserController.*(..))")
    public void vertify() {

    }

    @Before("vertify()")
    public void doVertify() {
        // 1. 获取request
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 2. 查询cookie
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie == null) {
            log.warn("【登录校验】Cookie中查不到token");
            throw new SellerAuthorizeException();
        }

        // 3. 查询redis
        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
        if (StringUtils.isEmpty(tokenValue)) {
            log.warn("【登录校验】Redis中查不到token");
            throw new SellerAuthorizeException();
        }

    }
}
