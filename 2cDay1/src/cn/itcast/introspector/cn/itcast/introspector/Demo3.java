package cn.itcast.introspector;
/*
 BeanUtils:
 把对象的属性数据封装到对象中。
*/

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo3  {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        String id = "110";
        String name="嘉诚";
        String salary = "1000000";
        String birthday = "1995-8-1";



        //注册类型转换器
        ConvertUtils.register(new Converter() {
            @Override
            public Object convert(Class type, Object value) {
                Date date = null;
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    date = dateFormat.parse((String)value);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return date;
            }
        }, Date.class);

        Emp p = new Emp();
        BeanUtils.setProperty(p,"id",id);
        BeanUtils.setProperty(p,"name",name);
        BeanUtils.setProperty(p,"salary",salary);
        BeanUtils.setProperty(p,"birthday",birthday);
        //Emp p = new Emp(110, "fj", 30000);
        System.out.println(p);
    }
}
