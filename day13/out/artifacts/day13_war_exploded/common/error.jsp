<%--
  Created by IntelliJ IDEA.
  User: jc
  Date: 2019-04-18
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>错误处理页面</title>
</head>
<body>
    系统错误请等待。。。
错误原因：<%=exception.getMessage() %>
</body>
</html>
