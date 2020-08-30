<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: WuLei
  Date: 2020/8/23
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>管理员登录</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="icon" sizes="any" mask="" href="http://www.baidu.com/img/baidu_85beaf5496f291521eb75ba38eacbd87.svg">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function refreshCode() {
            $("#vcode").attr("src", "/Servlet1/verifyCodeServlet?" + new Date().getTime());
        }
    </script>
</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">管理员登录</h3>
    <form action="/Servlet1/loginServlet" method="post">
        <div class="form-group">
            <label for="user">用户名：</label>
            <input type="text" name="account" class="form-control" id="user" placeholder="请输入用户名"/>
        </div>

        <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
        </div>

        <div class="form-inline">
            <label for="vcode">验证码：</label>
            <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="请输入验证码" style="width: 120px;"/>
            <a href="javascript:refreshCode()"><img src="/Servlet1/verifyCodeServlet" title="看不清点击刷新" id="vcode"/></a>
        </div>
        <hr/>
        <div class="form-group" style="text-align: center;">
            <input class="btn btn btn-primary" type="submit" value="登录">
        </div>
    </form>

    ${userResult}
    ${verifyResult}
    <!-- 出错显示的信息框 -->
    <c:if test="${not empty(userResult) or not empty(verifyResult)}">
        <div class="alert alert-warning alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" >
                <span>&times;</span></button>
            <strong>登录失败
                <c:if test="${not empty(verifyResult)}">， ${verifyResult}</c:if>
                <c:if test="${not empty(userResult)}">， ${userResult}</c:if>
            </strong>
        </div>
    </c:if>
</div>
</body>
</html>
