<%--
  Created by IntelliJ IDEA.
  User: jc
  Date: 2019-04-18
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="day13_el.entity.Student,java.util.*" %>
<%--导入标签库--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>核心标签库</title>
</head>
<body>
<%--使用标签--%>
<%--set标签：保存数据(保存到域中)默认保存到page域--%>
<c:set var="name" value="rose" scope="request"></c:set>
<%
    String msg = null;
    pageContext.setAttribute("msg",msg);
%>
${msg}
<br/>
<%--out标签：从域中获取数据--%>
<c:out value="${msg}" default="<h3>标题3</h3>" escapeXml="false"></c:out>
<hr/>
<%--if标签：单条件判断--%>
<c:if test="${10>5}">
    条件成立
</c:if>
<hr/>
<%--choose标签+when标签+otherwise标签--%>
<c:set var="score" value="20"></c:set>
<c:choose>
    <c:when test="${score>=90 && score<=100 }">
        优秀
    </c:when>
    <c:when test="${score>=80 && score<=90 }">
        良好
    </c:when>
    <c:otherwise>不及格</c:otherwise>
</c:choose>
<hr/>
<%--forEach循环--%>
<%
    //List
    List<Student> list = new ArrayList<>();
    list.add(new Student("rose", 19));
    list.add(new Student("jack", 29));
    list.add(new Student("lucy", 39));
    //放入域中
    pageContext.setAttribute("list",list);

    //Map
    Map<String, Student> map = new HashMap<>();
    map.put("100", new Student("mark", 20));
    map.put("101", new Student("mmaxwell", 30));
    map.put("102", new Student("narci", 40));
    //放入域中
    pageContext.setAttribute("map",map);
%>

<c:forEach begin="1" end="2" step="1" items="${list}" var="student" varStatus="varSta">
    序号：${varSta.count} 姓名：${student.name} - 年龄：${student.age}<br/>
</c:forEach>
<hr/>
<c:forEach items="${map}" var="entry">
    ${entry.key} - 姓名：${entry.value.name} - 年龄：${entry.value.age}<br/>
</c:forEach>
<hr/>
<%--forToken：循环特殊字符串--%>
<%
    String str = "java-php-net-平面";
    pageContext.setAttribute("str",str);
%>
<c:forTokens items="${str}" delims="-" var="s">
    ${s}<br/>
</c:forTokens>
<hr/>
<%--redirict:重定向--%>
<c:redirect url="http://www.baidu.com"></c:redirect>
</body>
</html>
