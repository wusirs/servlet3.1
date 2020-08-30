<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jsp.entry.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: WuLei
  Date: 2020/8/22
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>练习</title>
    <style type="text/css">
        .col-0{
            background: rgba(180,180,180,0.44);
        }
        .col-1{
            background: white;
        }
    </style>
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

    <table border="1px" cellspacing="0px" width="400px" align="center">
            <tr>
                <th>索引</th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>密码</th>
            </tr>
        <c:forEach items="${users}" var="user" varStatus="state">
            <tr class="col-${state.count mod 2}">
                <td>${state.count}</td>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td>${user.password}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
