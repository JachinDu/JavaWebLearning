package com.jachincloud.user.controller;

import com.jachincloud.user.VO.ResultVO;
import com.jachincloud.user.constant.CookieConstant;
import com.jachincloud.user.constant.RedisConstant;
import com.jachincloud.user.entity.UserInfo;
import com.jachincloud.user.enums.ResultEnum;
import com.jachincloud.user.enums.RoleEnum;
import com.jachincloud.user.service.UserService;
import com.jachincloud.user.utils.CookieUtil;
import com.jachincloud.user.utils.ResultVOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2020/01/07 16:46
 */
@RestController
@RequestMapping("/login")
public class LoginController {


    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 买家登录
     * @param openid
     * @return
     */
    @GetMapping("/buyer")
    public ResultVO buyer(@RequestParam("openid") String openid,
                          HttpServletResponse response) { // 需要获取openid，因为要写东西到cookie，所以需要获得response

        // 1. openid和数据库里的数据匹配
        UserInfo userInfo = userService.findByOpenid(openid);
        if (userInfo == null) {
            return ResultVOUtils.error(ResultEnum.LOGIN_FAIL);
        }
        // 2. 判断角色
        if (!RoleEnum.BUYER.getCode().equals(userInfo.getRole())) {
            return ResultVOUtils.error(ResultEnum.ROLE_ERROR);
        }
        // 3. 设置cookie openid=abc
        CookieUtil.set(response, CookieConstant.OPENID, openid, CookieConstant.expire);
        return ResultVOUtils.success();

    }


    /**
     * 卖家登录
     *
     * @param openid
     * @return
     */
    @GetMapping("/seller")
    public ResultVO seller(@RequestParam("openid") String openid,
                          HttpServletRequest request,
                          HttpServletResponse response) { // 需要获取openid，因为要写东西到cookie，所以需要获得response

        // 0. 判断是否已登陆
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie != null &&
                !StringUtils.isEmpty(stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TEMPLATE, cookie.getValue())))) {
            return ResultVOUtils.success();
        }

        // 1. openid和数据库里的数据匹配
        UserInfo userInfo = userService.findByOpenid(openid);
        if (userInfo == null) {
            return ResultVOUtils.error(ResultEnum.LOGIN_FAIL);
        }
        // 2. 判断角色
        if (!RoleEnum.SELLER.getCode().equals(userInfo.getRole())) {
            return ResultVOUtils.error(ResultEnum.ROLE_ERROR);
        }
        // 3. redis设置key=UUID，value=xyz
        String token = UUID.randomUUID().toString();
        Integer expire = CookieConstant.expire;
        stringRedisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_TEMPLATE, token),
                openid,
                expire,
                TimeUnit.SECONDS);

        // 4. 设置cookie token = UUID
        CookieUtil.set(response, CookieConstant.TOKEN, token, CookieConstant.expire);
        return ResultVOUtils.success();

    }

}
