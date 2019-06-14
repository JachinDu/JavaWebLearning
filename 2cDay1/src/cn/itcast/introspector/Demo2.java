package cn.itcast.introspector;

import javafx.beans.property.Property;
import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo2 {
//    public static void main(String[] args) {
//
//    }
    @Test
    public void getAllProperty() throws IntrospectionException {
        //Introspector 内省类
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
        //通过BeanInfo获取所有的属性描述器
        PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
        for(PropertyDescriptor p : descriptors){
            System.out.println(p.getReadMethod());
        }
    }

    @Test
    public void testProperty() throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Person p = new Person();
        PropertyDescriptor descriptor = new PropertyDescriptor("id", Person.class);
        Method m = descriptor.getWriteMethod();  //获取set方法
        m.invoke(p, 110);
        Method readMethod = descriptor.getReadMethod();   //获取get方法
        System.out.println(readMethod.invoke(p,null));
    }
}
