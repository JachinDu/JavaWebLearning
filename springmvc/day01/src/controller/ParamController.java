package controller;

import domin.Account;
import domin.User;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
* 请求参数绑定
* */
@Controller
@RequestMapping("/param")
public class ParamController {

    /*
    * 请求参数绑定入门
    * */
    @RequestMapping("/testParam")
    public String testParam(String username,String password) {
        System.out.println("执行了。。。。。");
        System.out.println("用户名："+username+" 密码："+password);
        return "success";
    }

    /*
     * 请求参数绑定把数据封装到javabean中
     * */
    @RequestMapping("/saveAccount")
    public String savaAccount(Account account) {
        System.out.println("执行了。。。。");
        System.out.println(account);
        return "success";
    }

    /*
     * 自定义类型转换器
     * */
    @RequestMapping("/saveUser")
    public String saveUser(User user) {
        System.out.println("执行了。。。。");
        System.out.println(user);
        return "success";
    }

    /*
     * 获取servlet原生api
     * 直接在函数的参数注明request和response就可以获取
     * */
    @RequestMapping("/servletAPI")
    public String servletAPI(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("执行了。。。。");
        System.out.println(request);

        HttpSession session = request.getSession();
        System.out.println(session);

        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);

        System.out.println(response);

        return "success";
    }
}
