import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/11/28 13:43
 */


public class CreateInstance {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, CloneNotSupportedException, IOException {
//        Student stu = (Student)Class.forName("Student").newInstance();
        Student stu = Student.class.newInstance();
//        Constructor<Student> constructor = Student.class.getConstructor(int.class); // 调用有参构造器
//        Student stu = constructor.newInstance(123);
////        Student stu1 = (Student) stu.clone();
//
//        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("student.bin"));
//        outputStream.writeObject(stu);
//        outputStream.close();
//
//        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("student.bin"));
//        Student stu1 = (Student) inputStream.readObject();
        stu.shuchu();
    }
}
