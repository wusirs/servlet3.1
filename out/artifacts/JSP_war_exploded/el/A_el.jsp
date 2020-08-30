<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.jsp.entry.User" %><%--
  Created by IntelliJ IDEA.
  User: WuLei
  Date: 2020/8/20
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- isELIgnored="true" 会默认忽略EL表达式 --%>
<%--<%@ page isELIgnored="true"%>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
\${1 > 3} : ${1 > 3}
<hr>
<h1>运算符</h1>
<h2>算数运算符</h2>
3 + 4 = ${3 + 4}<br>
3 - 4 = ${3 - 4}<br>
3 * 4 = ${3 * 4}<br>
3 / 4 = ${3 / 4},
3 div 4 = ${3 div 4}<br>
3 % 4 = ${3 % 4},
3 mod 4 = ${3 mod 4}<br>
<h2>比较运算符</h2>
3 == 4 : ${3 == 4}<br>
3 != 4 : ${3 != 4}<br>
3 > 4 : ${3 > 4}<br>
3 < 4 : ${3 < 4}<br>
3 >= 4 : ${3 >= 4}<br>
3 <= 4 : ${3 <= 4}<br>
<h2>逻辑运算符</h2>
3 > 4 && 3 < 4 : ${3 > 4 && 3 < 4}<br>
3 > 4 and 3 < 4 : ${3 > 4 and 3 < 4}<br>
3 > 4 || 3 < 4 : ${3 > 4 || 3 < 4}<br>
3 > 4 or 3 < 4 : ${3 > 4 or 3 < 4}<br>
!(3 < 4) : ${!(3 < 4)}<br>
not(3 < 4) : ${not(3 > 4)}<br>
<h2>空运算符</h2>
<%
    request.setAttribute("user1", new User(1001, "张三", "112112"));
    session.setAttribute("favors", new String[]{"吃", "喝", "玩", "乐"});
    pageContext.setAttribute("list", new ArrayList<>());
    application.setAttribute("list", new String[]{});
%>
user1 : ${empty requestScope.user1} <br>
list : ${empty pageScope.list}


</body>
</html>
