<%--
  Created by IntelliJ IDEA.
  User: jc
  Date: 2019-04-28
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <form name="frm1" action="ServletAdmin?method1=register" method="post">
        <table>
            <tr>
                <th>用户名</th>
                <td>
                    <input type="text" name="userName"/>
                    ${requestScope.message}
                </td>
            </tr>
            <tr>
                <th>密码</th>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="点击注册！"/>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
