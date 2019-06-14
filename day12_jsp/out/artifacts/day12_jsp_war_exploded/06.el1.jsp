<%--
  Created by IntelliJ IDEA.
  User: jc
  Date: 2019-04-18
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<html>
<head>
    <title>EL语法</title>
</head>
<body>
    <%
        String name = "rose";
        //放入域中
        pageContext.setAttribute("name", name);
    %>
<br/>
EL表达式：${name}
</body>
</html>
