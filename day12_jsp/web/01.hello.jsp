<%--
  Created by IntelliJ IDEA.
  User: jc
  Date: 2019-04-17
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,java.text.*" %>
<html>
<head>
    <title>第一个jsp页面</title>
</head>
<body>
    <%
        //java代码
        //获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat();
        String curDate = sdf.format(new Date());
        //输出到浏览器
        out.write("当前时间为：" + curDate);
    %>
</body>
</html>
