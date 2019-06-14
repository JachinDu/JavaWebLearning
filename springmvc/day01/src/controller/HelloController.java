package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//控制器类
@Controller
public class HelloController {

    @RequestMapping(path="/hello",method = {RequestMethod.POST})
    public String sayHello() {
        System.out.println("hello springmvc");
        return "success";
    }
}
