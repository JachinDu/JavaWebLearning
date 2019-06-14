<%--
  Created by IntelliJ IDEA.
  User: jc
  Date: 2019-04-19
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="day12.contact.entity.*,java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>查询所有联系人</title>
    <style type="text/css">
        table td{
            /*文字居中*/
            text-align:center;
        }

        /*合并表格的边框*/
        table{
            border-collapse:collapse;
        }
    </style>
</head>

<body>
<center><h3>查询所有联系人(jsp版本)</h3></center>
<table align="center" border="1" width="700px">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>电话</th>
        <th>操作</th>
    </tr>

<%--    遍历从request域中接收到的数据--%>
<c:forEach items="${contact}" var="contact">
    <tr>
        <td>${contact.id}</td>
        <td>${contact.name}</td>
        <td>${contact.gender}</td>
        <td>${contact.age}</td>
        <td>${contact.phone}</td>
        <td><a href="ServletQueryContact?id=${contact.id}">修改</a>&nbsp;<a href="ServletDeleteContact?id=${contact.id}">删除</a></td>
    </tr>
    </c:forEach>
    <tr>
        <td colspan="8" align="center"><a href="addPeople.jsp">[添加联系人]</a></td>
    </tr>
</table>
</body>
</html>
