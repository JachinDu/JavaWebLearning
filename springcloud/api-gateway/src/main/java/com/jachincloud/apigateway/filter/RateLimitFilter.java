package com.jachincloud.apigateway.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.jachincloud.apigateway.exception.RateLimitException;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;

/**
 * @description: 限流
 * @Author: JachinDo
 * @Date: 2020/01/07 16:14
 */
@Component
public class RateLimitFilter extends ZuulFilter {

    // 直接用google的组件 RateLimiter
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(100); // 每秒钟放几个令牌

    @Override
    public String filterType() {
        return PRE_TYPE;  // 限流，肯定要最高优先类型
    }

    @Override
    public int filterOrder() {
        return SERVLET_DETECTION_FILTER_ORDER - 1; // 要比最高优先级还要小
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        if (!RATE_LIMITER.tryAcquire()) { // 尝试获取令牌
            throw new RateLimitException();
        }
        return null;
    }
}
