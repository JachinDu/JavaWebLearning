package a_loginFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
* 无效数据过滤
* */
public class DataFilter implements Filter {
    //初始化无效数据
    private List<String> dirtyData;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //模拟几个数据
        dirtyData = new ArrayList<>();
        dirtyData.add("nnd");
        dirtyData.add("jb");
        dirtyData.add("草你妈");
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
        //获取请求数据值
        String value = request.getParameter("content");
        //如果value中有dirtyData中的数据，用***替换
        for (String data : dirtyData) {

            if (value == null) {
                break;
            }
            //注意contains和repalce用法！！！
            if (value.contains(data)) {
                System.out.println("value: "+value);
                value = value.replace(data, "*****");

            }
        }
        request.setAttribute("content",value);
        System.out.println("after : "+request.getParameter("content"));

        //2.放行（执行下一个过滤器或servlet）
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
