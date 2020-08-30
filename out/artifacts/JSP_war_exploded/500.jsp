<%--
  Created by IntelliJ IDEA.
  User: WuLei
  Date: 2020/8/20
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 出错跳转页面 --%>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>出错了...</title>
    <style type="text/css">
        #error-message{
            color: red;
        }
    </style>
</head>
<body>
    <h1>服务器正忙...</h1>
    <p id="error-message">
        <%
<%--            // message只有在配置了<%@ page isErrorPage="true" %> 的页面才能使用 --%>
            String message = exception.getMessage();
            out.write(message);
        %>
    </p>
</body>
</html>
