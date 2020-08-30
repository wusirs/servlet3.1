<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: WuLei
  Date: 2020/8/21
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>if标签</title>
</head>
<body>
    <%
        session.setAttribute("age", 12);
    %>

    <c:if test="true">
        true执行的代码
    </c:if>
    <br>
    <c:if test="${age == 12}">
        年龄为12
    </c:if>
    <br>
    <c:if test="${age == '12'}">
        年龄为12
    </c:if>

    <%
        //判断request域中的list集合是否为空，如果不为null则遍历集合
        List list = new ArrayList();
        list.add("aa");
        list.add("bb");

        request.setAttribute("list", list);

        request.setAttribute("num", new Random().nextInt(12));
    %>

    <c:if test="${not empty list}">
        集合不为空，遍历集合
    </c:if>
    <br>
    <c:if test="${(num mod 2) == 0}">
        ${num}为偶数。
    </c:if>
    <c:if test="${(num mod 2) == 1}">
        ${num}为奇数。
    </c:if>
    <br>
</body>
</html>
