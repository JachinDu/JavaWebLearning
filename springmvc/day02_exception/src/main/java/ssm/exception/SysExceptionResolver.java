package ssm.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
* 异常处理器
* */
public class SysExceptionResolver implements HandlerExceptionResolver {
    /*
    * 处理异常业务逻辑
    * */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //获取异常对象
        SysException exception = null;
        if (e instanceof SysException) {
            exception = (SysException) e;
        } else {
            exception = new SysException("系统正在维护。。。");
        }
        //创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        //将对象存入request域
        mv.addObject("errorMsg", exception.getMessage());
        //跳转页面
        mv.setViewName("error");
        return mv;
    }
}
