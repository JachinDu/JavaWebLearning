<%--
  Created by IntelliJ IDEA.
  User: jc
  Date: 2019-05-18
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <form name="frmLogin" action="${pageContext.request.contextPath }/login" method="post">
      用户名：<input type="text" name="userName"><br/>
      <input type="submit" value="POST提交">
    </form>
    <hr/>
    <form name="frmLogin" action="${pageContext.request.contextPath }/login" method="get">
      用户名：<input type="text" name="userName"><br/>
      <input type="submit" value="GET提交">
    </form>
  </body>
</html>
