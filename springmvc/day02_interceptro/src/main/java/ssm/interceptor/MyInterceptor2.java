package ssm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
* 自定义拦截器
* 必须实现HandlerInterceptor接口
* */
public class MyInterceptor2 implements HandlerInterceptor {

    /*
    * 预处理，controller方法执行前
    * return true 放行，执行下一个拦截器，或者controller中方法
    *        false 不放行，利用request,跳转到其他页面
    *                     如：request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
    * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor1执行了。。。。。前22222");
        //request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
        return true;
    }


    /*
    * 后处理方法，controller方法执行后，success.jsp执行前
    * 这里也可以使用request指定页面跳转
    * */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor1执行了。。。。。后22222");

    }


    /*
    * success.jsp页面执行后，该方法会执行
    * */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor1执行了。。。。。最后22222");
    }
}
