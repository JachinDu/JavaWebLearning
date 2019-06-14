package com.imooc.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CollectionsTest {

    public void testSort1()
    {
        List<Integer> integerList = new ArrayList<Integer>();
        Random random = new Random();
        Integer k;
        for ( int i = 0; i < 10; i++ )
        {
           do {
               k = random.nextInt(100);
           }while (integerList.contains(k));
           integerList.add(k);
           System.out.println("成功添加整数：" + k);
        }
        System.out.println("-----------排序前----------");
        for ( Integer integer : integerList)
        {
            System.out.println("元素：" + integer);
        }

        Collections.sort(integerList);
        System.out.println("-----------排序后----------");
        for ( Integer integer : integerList)
        {
            System.out.println("元素：" + integer);
        }
    }

    public void testSort2()
    {
        List<String> stringList = new ArrayList<String>();
        stringList.add("microsoft");
        stringList.add("google");
        stringList.add("lenovo");
        System.out.println("-----------排序前----------");
        for ( String string : stringList )
        {
            System.out.println("元素：" + string);
        }
        Collections.sort(stringList);
        System.out.println("-----------排序后----------");
        for ( String string : stringList)
        {
            System.out.println("元素：" + string);
        }
    }

    public void testSort3()
    {
        List<Student> studentList = new ArrayList<Student>();
        Random random = new Random();
        studentList.add(new Student(random.nextInt(1000) + "","Mike"));
        studentList.add(new Student(random.nextInt(1000) + "","Angel"));
        studentList.add(new Student(random.nextInt(1000) + "","Lucy"));

        studentList.add(new Student(10000 + "","Beyonce"));

        System.out.println("-----------排序前----------");
        for ( Student student : studentList )
        {
            System.out.println("学生：" + student.id + ":" + student.name);
        }

        Collections.sort(studentList);

        System.out.println("-----------排序后----------");
        for ( Student student : studentList )
        {
            System.out.println("学生：" + student.id + ":" + student.name);
        }

        Collections.sort(studentList,new StudentComparator());
        System.out.println("---------------按照姓名排序后---------------");
        for ( Student student : studentList )
        {
            System.out.println("学生：" + student.id + ":" + student.name);
        }

    }

    public static void main(String[] args)
    {
        CollectionsTest ct = new CollectionsTest();
        //ct.testSort1();
        //ct.testSort2();
        ct.testSort3();
    }
}
