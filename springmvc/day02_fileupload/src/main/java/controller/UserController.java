package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    /*
    * 文件上传
    * */
    @RequestMapping("/fileupload1")
    public String fileupload1() {
        System.out.println("文件上传");
        return "success";
    }
}
