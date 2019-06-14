package a_beans;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class App {

    //1.对javabean的基本操作
    @Test
    public void test1() throws InvocationTargetException, IllegalAccessException {
        //a.基本操作
        Admin admin = new Admin();
//        admin.setUserName("Jack");
//        admin.setPassword("999");

        //b.BeanUtil组建实现对象属性的拷贝
        BeanUtils.copyProperty(admin,"userName","jack");
        BeanUtils.setProperty(admin,"age","18");

        //c.对象的拷贝
        Admin newAdmin = new Admin();
        BeanUtils.copyProperties(newAdmin,admin);

        //d.map数据，拷贝到对象中
        Admin adminMap = new Admin();
        Map<String, Object> map = new HashMap<>();
        map.put("userName", "Jerry");
        map.put("age", 29);
        BeanUtils.populate(adminMap,map);
        System.out.println(adminMap.getUserName());
        System.out.println(adminMap.getAge());

    }
}
