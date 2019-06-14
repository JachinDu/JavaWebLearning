package controller;

import domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    /*
    * 返回类型String
    * */
    @RequestMapping("/testString")
    public String testString(Model model) {
        System.out.println("testString执行了。。。");
        //模拟从数据库中查出了User对象
        User user = new User();
        user.setAge(30);
        user.setPassword("123");
        user.setUsername("嘉诚");
        //model对象将该属性存入了request域对象中
        model.addAttribute("user", user);
        return "success";
    }

    /*
    * 返回类型void
    * */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid执行了。。。");
        //1、编写请求转发程序
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        //2、重定向
        //注意，重定向无法直接访问到WEB-INF中的jsp，只能访问web目录下的，如index.jsp
//        response.sendRedirect(request.getContextPath() + "/index.jsp");

        //3、直接进行响应
        //设置中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().println("你好");
        return;
    }

    /*
     * 返回类型ModelAndView
     * */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        //创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        System.out.println("testModelAndView执行了。。。");
        //模拟从数据库中查出了User对象
        User user = new User();
        user.setAge(30);
        user.setPassword("123");
        user.setUsername("奕杉");
        //ModelAndView对象将该属性存入了request域对象中
        mv.addObject("user", user);

        //跳转到哪个页面
        mv.setViewName("success");
        return mv;
    }


    /*
    * 模拟异步请求响应
    * ResponseBody：自动将返回类型转化为客户端dataType定义到类型（此处将User转为json串）
    * */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user) {
        //拿到请求体中的json串
        System.out.println("testAjax执行了。。。");
        //客户端发送ajax请求，传来json串，后端把json串自动封装到user对象中
        System.out.println(user);
        //做响应，模拟查询数据库
        user.setUsername("lele");
        user.setAge(16);
        //做响应
        return user;
    }


}
