<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: WuLei
  Date: 2020/8/22
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>forEach标签</title>
</head>
<body>
    <c:forEach begin="1" end="10" var="i" step="1">
        ${i}
        <c:if test="${i < 10}">
            ,
        </c:if>
    </c:forEach> <br>

    ------------------------------------<br>
    <c:forEach begin="1" end="10" var="i" step="1" varStatus="s">
        ${i}, index: ${s.index}, count: ${s.count}<br>
    </c:forEach><br>

    <%
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        list.add("h");
        list.add("i");
        request.setAttribute("list",list);
    %><br>

    -------------------------------------<br>
    <c:forEach items="${list}" var="str" varStatus="state">
        ${str} -- > index -- ${state.index} --- count --- ${state.count}, <br>
    </c:forEach><br>
</body>
</html>
