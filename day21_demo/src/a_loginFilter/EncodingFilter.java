package a_loginFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
* 编码处理统一在这里，servlet中不需要再处理编码
* */
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    //过滤器业务处理方法
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //转型,若想使用更通用的request和response方法则须转型
        //注意区别HttpServletRequest和ServletRequest是两种不同类型
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        //1.处理公用业务
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //2.放行（执行下一个过滤器或servlet）
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
