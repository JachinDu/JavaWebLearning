package utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
* 把字符串转成日期*/
//实现接口时要指定<传入类型，目标类型>,因为Converter<S,T>接口时泛型的
public class StringToDateConverter implements Converter<String, Date> {

    /*
    * String s: 传进来的字符串
    * */
    @Override
    public Date convert(String s) {
        //判断
        if (s == null) {
            throw new RuntimeException("请传入数据");
        }
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");

        try {
            //把字符串转换成日期
            return df.parse(s);
        } catch (Exception e) {
            throw new RuntimeException("数据类型转换出现错误");
        }
    }
}
