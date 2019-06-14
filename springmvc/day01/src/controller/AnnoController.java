package controller;

import domin.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

/*
* 常用注解
* */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"})
public class AnnoController {

    /*解决参数名称匹配*/
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String username) {
        System.out.println("执行了。。。");
        System.out.println(username);
        return "success";
    }

    /*获取请求体内容*/
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println("执行了。。。");
        System.out.println(body);
        return "success";
    }

    /*PathVariable注解*/
    @RequestMapping("/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name = "sid") String id) {
        System.out.println("执行了。。。");
        System.out.println(id);
        return "success";
    }

    /*ModelAttribute注解*/
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user) {
        System.out.println("testModelAttribute执行了。。。");
        System.out.println(user);
        return "success";
    }

    /*
    * 该方法先执行
    * */
//    @ModelAttribute
//    public User showUser(String uname) {
//        System.out.println("showUser执行了。。。");
//        //通过用户名查询数据库（模拟）
//        User user = new User();
//        user.setDate(new Date());
//        return user;
//    }

    @ModelAttribute
    public void showUser(String uname, Map<String,User> map) {
        System.out.println("showUser执行了。。。");
        //通过用户名查询数据库（模拟）
        User user = new User();
        user.setDate(new Date());
        map.put("abc", user);
    }


    /*SessionAttributes注解*/
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model) {
        System.out.println("testSessionAttributes执行了。。。");
        //底层会存储到request域对象中
        model.addAttribute("msg","美美");
        return "success";
    }

    /*SessionAttributes获取共享参数msg*/
    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap) {
        System.out.println("getSessionAttributes执行了。。。");
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    /*SessionAttributes清除session*/
    @RequestMapping("/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status) {
        System.out.println("delSessionAttributes执行了。。。");
        //清除session
        status.setComplete();
        return "success";
    }


}
