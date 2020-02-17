package com.jachincloud.apigateway.filter;

import com.jachincloud.apigateway.constant.RedisConstant;
import com.jachincloud.apigateway.utils.CookieUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @description: 权限拦截（区分买家和卖家）
 * @Author: JachinDo
 * @Date: 2020/01/06 21:30
 */
@Component
public class AuthFilter extends ZuulFilter {



    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    // 指定过滤器类型
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    // 过滤器优先级，越小越优先
    @Override
    public int filterOrder() {
        // 相当于优先于PRE_DECORATION_FILTER_ORDER类型的前置过滤器
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    // 是否开启过滤
    @Override
    public boolean shouldFilter() {
        return true;
    }

    // 过滤器逻辑
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        /**
         * /order/create 只能买家访问（cookie里有openid）
         * /order/finish 只能卖家访问（cookie里有token，并且对应的redis有值）
         * /product/list 都可访问
         */
        if ("/order/order/create".equals(request.getRequestURI())) {
            Cookie cookie = CookieUtil.get(request, "openid");
            if (cookie == null || StringUtils.isEmpty(cookie.getValue())) {
                currentContext.setSendZuulResponse(false); // 表示请求不通过
                currentContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            }
        } else if ("/order/order/finish".equals(request.getRequestURI())) {
            Cookie cookie = CookieUtil.get(request, "token");
            if (cookie == null // cookie为null
                    || StringUtils.isEmpty(cookie.getValue()) // cookie的值为空，下面是redis中值为空
                    || StringUtils.isEmpty(stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TEMPLATE, cookie.getValue())))) {

                currentContext.setSendZuulResponse(false); // 表示请求不通过
                currentContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            }
        }

        return null;
    }
}
