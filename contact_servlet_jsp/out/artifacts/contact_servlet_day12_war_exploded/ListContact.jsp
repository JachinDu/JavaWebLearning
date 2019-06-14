<%--
  Created by IntelliJ IDEA.
  User: jc
  Date: 2019-04-18
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="day12.contact.entity.*,java.util.*" %>
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
    <%
        //从request域中接收数据
        List<Contact> list = (List<Contact>)request.getAttribute("contacts");

        for(Contact con:list){
    %>
    <tr>
        <td><%=con.getId() %></td>
        <td><%=con.getName() %></td>
        <td><%=con.getGender() %></td>
        <td><%=con.getAge() %></td>
        <td><%=con.getPhone() %></td>
        <td><a href="modify.html">修改</a>&nbsp;<a href="checkall.html">删除</a></td>
    </tr>
    <%
        }
    %>
    <tr>
        <td colspan="8" align="center"><a href="添加联系人.html">[添加联系人]</a></td>
    </tr>
</table>
</body>
</html>
