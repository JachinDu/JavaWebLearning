<%--
  Created by IntelliJ IDEA.
  User: jc
  Date: 2019-04-18
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>out对象</title>
</head>
<body>
    <%
        out.write("abc");
        System.out.println("当前缓冲区大小："+out.getBufferSize());
        System.out.println("缓冲区剩余："+out.getRemaining());
        response.getWriter().write("123");
    %>
</body>
</html>
