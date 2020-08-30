<%--
  Created by IntelliJ IDEA.
  User: WuLei
  Date: 2020/8/18
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>

    <style>
        #dialog-from-label{
            width: 500px;
            height: 400px;
            margin: auto;
            margin-top: 30px;
        }

        .error{
            color: #ff0000;
        }
    </style>

    <script src="/Servlet2/JS/jquery-1.8.3.min.js"></script>
    <script>
        $(function () {
            $("#verifyCodeImg").click(function () {
                $(this).prop("src", "/Servlet2/verifyCode?time=" + new Date().getTime());
            });
        });
        // window.onload = function () {
        //     document.getElementById("verifyCodeImg").onclick = function () {
        //         this.src = "/Servlet2/verifyCode?time=" + new Date().getTime();
        //     }
        // }
    </script>
</head>
<body>
    <div id="dialog-from-label">
        <form action="/Servlet2/loginServlet" method="post">
            <input type="text" name="account" placeholder="请输入用户名"/><br>
            <input type="password" name="password" placeholder="请输入密码"/><br>
            <input type="text" name="verifyCode" placeholder="请输入你看到的验证码"><br>
            <%--   src="/Servlet2/verifyCode"     --%>
            <img src="/Servlet2/verifyCode" id="verifyCodeImg"/><br>
            <input type="submit" value="登录">
        </form>

        <span class="error"><%=request.getSession().getAttribute("verifyResult") == null ? "" : "验证码有误"%></span><br>
        <span class="error"><%=request.getSession().getAttribute("userVerify") == null ? "" : request.getSession().getAttribute("userVerify")%></span>
    </div>
</body>
</html>
