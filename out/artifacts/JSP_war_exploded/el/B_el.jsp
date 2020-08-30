<%@ page import="com.jsp.entry.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: WuLei
  Date: 2020/8/20
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        session.setAttribute("user1", new User(1001, "李斯", "112112"));
        request.setAttribute("user1", new User(1001, "张三", "112112"));
        session.setAttribute("favors", new String[]{"吃", "喝", "玩", "乐"});
        pageContext.setAttribute("list", new ArrayList<>());
        application.setAttribute("list", new String[]{});
    %>
    <p>
        <h4>user1</h4>
        <h5>${requestScope.user1}</h5>
    </p>
    <p>
        <h4>favors</h4>
        <h5>${sessionScope.favors}</h5>
    </p>
    <p>
        <h4>list</h4>
        <h5>${pageScope.list}</h5>
    </p>
    <p>
        <h4>list</h4>
        <h5>${applicationScope.list}</h5>
    </p>
    <p>
        <h5>\${user1} -- ${user1}</h5>
    </p>
</body>
</html>
