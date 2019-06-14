<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jc
  Date: 2019-04-19
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang='en'>
<head>
    <meta charset='UTF-8'>
    <title>修改联系人(jsp)</title>
</head>
<body>
<center><h3>修改联系人(jsp)</h3></center>
<form action='ServletModifyContact' method='post'>
    <input type='hidden' name='id' value='${contact.id}'/>
    <table align='center' border='1' width='300px'>
        <tr>
            <th>姓名</th>
            <td><input type='text' name='name' value='${contact.name}'/></td>
        </tr>
        <tr>
            <th>性别</th>
            <td>
                <c:choose>
                    <c:when test="${contact.gender eq '男'}">
                        <input type='radio' name='gender' value='男' checked='checked'/>男
                        <input type='radio' name='gender' value='女'/>女
                    </c:when>
                    <c:when test="${contact.gender eq '女'}">
                        <input type='radio' name='gender' value='男' />男
                        <input type='radio' name='gender' value='女' checked='checked'/>女
                    </c:when>
                    <c:otherwise>错误</c:otherwise>
                </c:choose>
            </td>
        </tr>
        <tr>
            <th>年龄</th>
            <td><input type='text' name='age' value='${contact.age}'/></td>
        </tr>
        <tr>
            <th>电话</th>
            <td><input type='text' name='phone' value='${contact.phone}'/></td>
        </tr>
        <tr>
            <td colspan='2' align='center'>
                <input type='submit' value='保存'/>&nbsp;
                <input type='reset' value='重置'/></td>
        </tr>
    </table>
</form>
</body>
</html>
