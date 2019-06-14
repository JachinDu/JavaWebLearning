package h_annotation.b_web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

//web层（类似与servlet层）用@Controller
@Controller("studentAction")
public class StudentAction {

    //默认按照类型，这里是对私有字段设置
    //什么是按照类型呢，就是这里会找接口StudentService实现类的对象，有多个实现类时就要再加@Qualifier
    //这个注解就是告诉spring，StudentService对象还没有实例化，需要实例化
//    @Autowired
    @Resource(name = "studentService")
    private StudentService studentService;

    public void execute() {
        studentService.addStudent();
    }
}
