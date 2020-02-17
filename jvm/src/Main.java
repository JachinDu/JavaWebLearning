import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/12/01 20:48
 */

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

//        System.out.println("----------------------");
//        System.out.println(System.getProperty("sun.boot.class.path"));
//        System.out.println(System.getProperty("java.ext.dirs"));
//        System.out.println(System.getProperty("java.class.path"));
        MyClassLoader mcl = new MyClassLoader("myClassLoader1");
//        // 根据全限定名加载，注意，这里调用loadClass方法
//        Class<?> clazz = mcl.loadClass("Student");
//        Student student = (Student)clazz.newInstance();
        Object o = mcl.loadClass("Student").newInstance();
        o.getClass().getMethod("shuchu").invoke(o);
//        student.shuchu();
//        List<Integer> list = new ArrayList<>();
//        Object o = new Object();
        System.out.println(o.getClass().getClassLoader());
//        System.out.println(list.getClass().getClassLoader());
//        System.out.println(o.getClass().getClassLoader());
        byte[] allocation1, allocation2;
        allocation1 = new byte[30900 * 1024*2];
        allocation2 = new byte[900 * 1024*2];


    }
}
