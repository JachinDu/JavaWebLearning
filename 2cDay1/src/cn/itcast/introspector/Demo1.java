package cn.itcast.introspector;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Demo1 {
    public static void main(String[] args) throws NoSuchMethodException, IOException, InstantiationException, NoSuchFieldException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        Person p = (Person)getInstance();
        System.out.println(p);
    }

    public static Object getInstance() throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(("obj.txt")));
        String className = bufferedReader.readLine();
        Class clazz = Class.forName(className);
        Constructor constructor = clazz.getConstructor(null);
        Object o = constructor.newInstance(null);
        String line = null;
        while((line = bufferedReader.readLine())!=null){
            String[] datas = line.split("=");
            Field field = clazz.getDeclaredField(datas[0]);
            if(field.getType() == int.class){
                field.set(o, Integer.parseInt(datas[1]));
            }
            else{
                field.set(o, datas[1]);
            }

        }
    return o;

    }
}
