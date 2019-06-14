<%--
  Created by IntelliJ IDEA.
  User: jc
  Date: 2019-04-18
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>动作标签</title>
</head>
<body>
<%--转发--%>
<%
    //request.getRequestDispatcher("/09.action2.jsp?name=eric").forward(request,response);
%>
<jsp:forward page="09.action2.jsp">
    <jsp:param name="name" value="jacky"/>
</jsp:forward>

</body>
</html>
