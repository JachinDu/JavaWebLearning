<%--
  Created by IntelliJ IDEA.
  User: jc
  Date: 2019-04-18
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pageContext对象</title>
</head>
<body>
    <%
        //1)pageContext对象用来获取其他八个内置对象
        response.getWriter().write("是否相等？"+(out==pageContext.getOut()));
        //2）作为域对象使用
        //保存数据，默认情况下保存在page域中
        pageContext.setAttribute("message","djc's message");
        pageContext.setAttribute("message","request's message",PageContext.REQUEST_SCOPE);//保存在request域中
        //获取数据
        String message = (String) pageContext.getAttribute("message");
        String remessage = (String) request.getAttribute("message");
        out.write(message+" , "+remessage);
    %>
</body>
</html>
