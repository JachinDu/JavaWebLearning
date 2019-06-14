<%--
  Created by IntelliJ IDEA.
  User: jc
  Date: 2019-04-20
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp页面使用javabean</title>
</head>
<body>
<%--    创建对象--%>
<jsp:useBean id="stu" class="c_jb_entity.Student"></jsp:useBean>
<%--赋值--%>
<jsp:setProperty name="stu" property="name" value="jacky"/>
<%--获取--%>
<jsp:getProperty name="stu" property="name"/>
</body>
</html>
