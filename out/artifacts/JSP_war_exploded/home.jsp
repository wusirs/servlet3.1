<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: WuLei
  Date: 2020/8/17
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    // 不用再设置响应体编码和格式，再JSP开头已经声明好了
//    response.setContentType("text/html;charset=utf-8");
    Cookie[] cookies = request.getCookies();
    boolean flag = true;
    if (cookies != null && cookies.length > 0) {
        for (Cookie cookie : cookies) {
            if ("loginTime".equals(cookie.getName())) {
                flag = false;
                String loginTime = cookie.getValue();
                loginTime = URLDecoder.decode(loginTime, "utf-8");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                String newLoginTime = sdf.format(new Date());
                newLoginTime = URLEncoder.encode(newLoginTime, "utf-8");
                cookie.setValue(newLoginTime);
                cookie.setMaxAge(60 * 60 * 24 * 30); // 持久化三十天
                response.addCookie(cookie);
%>
<h1>欢迎您再次登录，您上次的登录时间为： <%= loginTime%>
</h1>
<%
                break;
            }
        }
    }

    if (cookies == null || flag) {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY年MM月dd日 HH:mm:ss");
        String loginTime = sdf.format(new Date());
        loginTime = URLEncoder.encode(loginTime, "utf-8");
        Cookie cookie = new Cookie("loginTime", loginTime);
        cookie.setMaxAge(60 * 60 * 24 * 30); // 持久化30天
        response.addCookie(cookie);
%>
<h1>欢迎您首次登录！</h1>
<%
    }
%>

</body>
</html>
