<%@ page import="com.jsp.entry.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: WuLei
  Date: 2020/8/22
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>表格</title>
    <link type="text/css" href="../css/bootstrap.min.css" rel="stylesheet">
    <script src="../js/jquery-3.2.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
</head>
<body>
<%--
需求：在request域中有一个存有User对象的List集合，需要
    使用jstl+el将list集合中数据展示到jsp页面的表格table中。
--%>

<%
    List<User> users = new ArrayList<User>();
    users.add(new User(1001, "张三", "男", 18, "12343216"));
    users.add(new User(1002, "李斯", "男", 17, "1232156"));
    users.add(new User(1003, "王二", "男", 21, "123321456"));
    users.add(new User(1004, "刘心", "男", 26, "12341256"));
    users.add(new User(1005, "钱七", "男", 20, "1241456"));
    users.add(new User(1006, "祁王", "男", 22, "123412356"));

    request.setAttribute("users", users);
%>

<div class="container">
    <div class="row">
        <div class="col-lg-3"></div>
        <div class="col-lg-6">
            <table class="table table-hover table-striped">
                <caption>用户信息表</caption>
                <thead>
                <tr>
                    <th>索引</th>
                    <th>编号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>密码</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="user" varStatus="state">
                    <tr>
                        <td>${state.count}</td>
                        <td>${user.id}</td>
                        <td>${user.username}</td>
                        <td>${user.gender}</td>
                        <td>${user.age}</td>
                        <td>${user.password}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-lg-3"></div>
    </div>
</div>

</body>
</html>
