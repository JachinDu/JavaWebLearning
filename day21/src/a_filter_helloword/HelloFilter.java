package a_filter_helloword;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/*
* 过滤器，测试
* */
public class HelloFilter implements Filter {

    //创建实例
    public HelloFilter() {
        System.out.println("1.创建过滤器实例");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2.执行过滤器初始化");
        //获取过滤器在web.xml中配置的初始化参数
        String encoding = filterConfig.getInitParameter("encoding");
        System.out.println(encoding);

        //获取过滤器在web.xml中配置的所有初始化参数名称
        Enumeration<String> enums = filterConfig.getInitParameterNames();
        while (enums.hasMoreElements()) {
            String name = enums.nextElement();
            String value = filterConfig.getInitParameter(name);
            System.out.println(name+"\t" + value);
        }
    }

    //过滤器业务处理方法：
    //在请求到达servlet之前先进入此方法处理公用的业务逻辑操作
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("3.执行过滤器业务处理");
        //放行（去到servlet）
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("5.servlet处理完成，又回到过滤器");
    }

    @Override
    public void destroy() {
        System.out.println("6.销毁过滤器实例");
    }
}
