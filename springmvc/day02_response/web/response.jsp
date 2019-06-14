<%--
  Created by IntelliJ IDEA.
  User: jc
  Date: 2019-06-11
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<%--    将jquery引入jsp--%>
    <script src="js/jquery.min.js"></script>
    <script>
        //页面加载，绑定单击事件
        $(function () {
            $("#btn").click(function () {
                // alert("hello btn");
                //发送ajax请求
                $.ajax({
                   //编写json格式，设置属性和值
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"hehe","password":"123","age":12}',
                    //dataType：是指要求服务端返回到类型
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        //data是服务器端响应的json数据，进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);

                    }
                });
            });
        });
    </script>
</head>
<body>
<a href="user/testString">testString</a>
<br>
<a href="user/testVoid">testVoid</a>
<br>
<a href="user/testModelAndView">testModelAndView</a>
<br>

<button id="btn">发送ajax的请求</button>
</body>
</html>
