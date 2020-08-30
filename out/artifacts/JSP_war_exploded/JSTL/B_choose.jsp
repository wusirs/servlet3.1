<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: WuLei
  Date: 2020/8/21
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>choose标签</title>
</head>
<body>
<%
    /**
     完成数字编号对应星期几案例
         1.域中存储数字；
         2.使用choose标签取出数字，相当于switch声明；
         3.使用when标签做数字判断，相当于case；
         4.otherwise标签做其他情况声明，相当于default；
     */

    request.setAttribute("week", new Random().nextInt(8));
%>
<h1>
    <c:choose>
        <c:when test="${week == 1}">星期一</c:when>
        <c:when test="${week == 2}">星期二</c:when>
        <c:when test="${week == 3}">星期三</c:when>
        <c:when test="${week == 4}">星期四</c:when>
        <c:when test="${week == 5}">星期五</c:when>
        <c:when test="${week == 6}">星期六</c:when>
        <c:when test="${week == 0}">星期天</c:when>
        <c:otherwise>数字不合法</c:otherwise>
    </c:choose>
</h1>
</body>
</html>
