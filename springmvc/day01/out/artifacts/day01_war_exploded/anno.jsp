<%--
  Created by IntelliJ IDEA.
  User: jc
  Date: 2019-06-10
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--常用注解--%>
<a href="anno/testRequestParam?name=哈哈">RequestParam</a>


<form action="/anno/testRequestBody" method="post">
    用户姓名：<input type="text" name="username" /><br/>
    用户年龄：<input type="text" name="age" /><br/>
    <input type="submit" value="提交" /><br/>
</form>

<a href="anno/testPathVariable/10">PathVariable</a>
<br>
<br>
<form action="/anno/testModelAttribute" method="post">
    用户姓名：<input type="text" name="uname" /><br/>
    用户年龄：<input type="text" name="age" /><br/>
    <input type="submit" value="提交" /><br/>
</form>


<br>
<br>
<a href="anno/testSessionAttributes">SessionAttributes</a>
<a href="anno/getSessionAttributes">getSessionAttributes</a>
<a href="/anno/delSessionAttributes">delSessionAttributes</a>



</body>
</html>
