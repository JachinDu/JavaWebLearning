<%@ page import="day13_el.entity.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: jc
  Date: 2019-04-18
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用EL输出不同类型数据</title>
    <%
        //保存数据
        Student student = new Student("eric", 20);

        //放域中
        pageContext.setAttribute("student",student);
        //List
        List<Student> list = new ArrayList<>();
        list.add(new Student("rose", 19));
        list.add(new Student("jack", 29));
        list.add(new Student("lucy", 39));
        //放入域中
        pageContext.setAttribute("list",list);

        //Map
        Map<String, Student> map = new HashMap<>();
        map.put("100", new Student("mark", 20));
        map.put("101", new Student("mmaxwell", 30));
        map.put("102", new Student("narci", 40));
        //放入域中
        pageContext.setAttribute("map",map);
    %>
<%--    使用EL获取对象--%>
${student.name}
<%--    .name不是访问name属性，而是调用name属性对应到方法getName()--%>
    <hr/>
<%--    使用El获取LIst对象--%>
    ${list[0].name} - ${list[0].age}
    <hr/>
<%--    使用EL获取Map--%>
    ${map['100'].name}
</head>
<body>
<%--1)El输出对象属性--%>
</body>
</html>
