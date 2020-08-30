<%@ page import="com.wu.web.cases.User" %><%--
  Created by IntelliJ IDEA.
  User: WuLei
  Date: 2020/8/19
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success Login</title>
</head>
<body>
    <h1><%=((User)request.getSession().getAttribute("userObject")).getUsername()%>，欢迎登录！</h1>
</body>
</html>
