<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: WuLei
  Date: 2020/8/21
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        session.setAttribute("list1", new ArrayList());
        session.setAttribute("array1", new String[]{"12", "13"});
        session.setAttribute("str", "");
    %>

    list1 --  ${empty list1}<br>
    array1 -- ${empty array1}<br>
    array1 -- ${not empty array1}<br>
    str -- ${empty str}
</body>
</html>
