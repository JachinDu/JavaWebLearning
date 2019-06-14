package h_annotation.b_web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//service层用@Service
@Service("studentService")
public class StudentServiceImpl implements StudentService{

    private StudentDao studentDao;

    //按名称注入，给setter方法设置
    @Autowired
    @Qualifier("studentDao")
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void addStudent() {
        studentDao.save();
    }
}
