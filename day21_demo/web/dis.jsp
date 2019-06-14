<%--
  Created by IntelliJ IDEA.
  User: jc
  Date: 2019-05-18
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
<%--    引入ckeditor组件（给用户输入提供方便）--%>
    <script type="text/javascript" src="${pageContext.request.contextPath }/ckeditor5-build-classic/ckeditor.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/ckeditor5-build-classic/sample/sample.css"/>

  </head>
  <body>
  内容：${requestScope.content }
    <form name="frmDis" action="${pageContext.request.contextPath }/ServletDis" method="post">
      发表评论：<textarea id="editor" rows="6" cols="30" name="content"></textarea>
        <script type="text/javascript" src="${pageContext.request.contextPath }/ckeditor5-build-classic/ckeditor.js"></script>

        <script>
            ClassicEditor.create(document.querySelector('#editor')); //
        </script>
<%--      <script type="text/javascript">CKEDITOR_TRANSLATIONS.replace("editor")</script>--%>

      <br/>
      <input type="submit" value="评论">
    </form>
  </body>

</html>
