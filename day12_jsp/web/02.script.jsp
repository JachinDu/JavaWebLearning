<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: jc
  Date: 2019-04-17
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>语法</title>
</head>
<body>
<%--jsp表达式--%>
<%
    //变量
    String name = "eric";
%>
<%=name%>
<hr/>
<%--jsp脚本--%>
<%
    Random ran = new Random();
    float num = ran.nextFloat();
%>
随机小数：<%=num%>
</body>
</html>
