package com.jachincloud.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2020/01/06 21:30
 */
@Component
public class TokenFilter extends ZuulFilter {
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
        return false;
    }

    // 过滤器逻辑
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();

        // 这里从url中获取，也可以从cookie、header中获取
        String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)) {
            currentContext.setSendZuulResponse(false); // 表示请求不通过
            currentContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value()); // 设置响应状态码
        }
        return null;
    }
}
