package com.imooc.collection;

import sun.jvm.hotspot.runtime.StubRoutines;

import java.util.*;

public class SetTest {

    public List<Course> coursesToSelect;
    private Scanner console;
    public Student student;

    public SetTest(){
        coursesToSelect = new ArrayList<Course>();
        console = new Scanner(System.in);
    }

    public void testAdd(){
        Course cr1 = new Course("1","数据结构");
        coursesToSelect.add(cr1);
        Course temp = (Course)coursesToSelect.get(0);
        System.out.println("添加了课程：" + temp.id + ":" + temp.name );


        Course cr2 = new Course("2","C语言");
        coursesToSelect.add(0,cr2);
        Course temp2 = (Course) coursesToSelect.get(0);
        //System.out.println("添加了课程：" + temp2.id + ":" + temp2.name );

//        coursesToSelect.add(cr1);
//        Course temp0 = (Course)coursesToSelect.get(2);
//        System.out.println("添加了课程：" + temp0.id + ":" + temp0.name );

        Course[] course = {new Course("3","离散数学"),new Course("4","汇编语言")};
        coursesToSelect.addAll(Arrays.asList(course));
        Course temp3 = (Course) coursesToSelect.get(2);
        Course temp4 = (Course) coursesToSelect.get(3);
        //System.out.println("添加了两门课程：" + temp3.id + ":" + temp3.name + ";" + temp4.id + ":" + temp4.name);


        Course[] course2 = {new Course("5","高等数学"),new Course("6","大学英语")};

        coursesToSelect.addAll(2,Arrays.asList(course2));
        Course temp5 = (Course) coursesToSelect.get(3);
        Course temp6 = (Course) coursesToSelect.get(4);
        //System.out.println("添加了两门课程：" + temp5.id + ":" + temp5.name + ";" + temp6.id + ":" + temp6.name);
    }

    public void testForEach(){
        System.out.println("有如下课程待选(ForEach）：");
        for (Object obj : coursesToSelect){
            Course cr = (Course) obj;
            System.out.println("课程：" + cr.id + ":" + cr.name);
        }
    }

    public static void main(String[] args)
        {
            SetTest st = new SetTest();
            st.testAdd();
            //st.testForEach();
//            st.createStudentAndSelectCours();
//            st.testSetContains();
            st.testListContains();
            st.testForEach();
//
//            Student student = new Student("1","小明");
//            System.out.println("欢迎学生：" + student.name + "选课！");
//
//            Scanner console = new Scanner(System.in);
//
//            for (int i = 0; i < 3; i++)
//            {
//                System.out.println("请输入课程ID");
//                String courseId = console.next();
//                for (Course cr : st.coursesToSelect)
//                {
//                    if(cr.id.equals(courseId))
//                    {
//                        student.courses.add(cr);
//                        student.courses.add(cr);
//                    }
//                }
//            }
//            st.testForEachForSet(student);
        }


    public void createStudentAndSelectCours()
    {
        student = new Student("1","小明");
        System.out.println("欢迎学生：" + student.name + "选课！");

        Scanner console = new Scanner(System.in);

        for (int i = 0; i < 3; i++)
        {
            System.out.println("请输入课程ID");
            String courseId = console.next();
            for (Course cr : coursesToSelect)
            {
                if(cr.id.equals(courseId))
                {
                    student.courses.add(cr);
                    student.courses.add(cr);
                }
            }
        }
    }

    public void testSetContains()
    {
        System.out.println("请输入学生已选的课程名称：");
        String name = console.next();

        Course course2 = new Course();
        course2.name = name;
        System.out.println("新创建课程：" + course2.name);
        System.out.println("备选课程中是否包含课程： " + course2.name + "," + student.courses.contains(course2));
        }

    public void testListContains()

    {
        Course course = coursesToSelect.get(0);
        System.out.println("取得课程：" + course.name);
        System.out.println("备选课程中是否包含课程： " + course.name + "," + coursesToSelect.contains(course));

        System.out.println("请输入课程名称：");
        String name = console.next();

        Course course2 = new Course();
        course2.name = name;
        System.out.println("新创建课程：" + course2.name);
        System.out.println("备选课程中是否包含课程： " + course2.name + "," + coursesToSelect.contains(course2));
        if(coursesToSelect.contains(course2))
            System.out.println("课程：" + course2.name + "的索引位置为：" + coursesToSelect.indexOf(course2)) ;

    }


    public void testForEachForSet(Student student)
    {
        System.out.println("共选择了：" + student.courses.size() + "门课程！");
        for ( Course cr : student.courses)
        {
            System.out.println("选择了课程：" + cr.id + ":" + cr.name);


        }
    }
}
