<%--
  Created by IntelliJ IDEA.
  User: WuLei
  Date: 2020/8/20
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:import url="500.jsp"></c:import>
<%
    // pageContext可以获取其他8个内置对象
    Exception exception = pageContext.getException();
%>
</body>
</html>
