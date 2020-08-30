<%@ page import="com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput" %><%--
  Created by IntelliJ IDEA.
  User: wulei
  Date: 2020/8/17
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        System.out.println("hello JSP");

        int i = 5;
        String contextPath = request.getContextPath();
        out.print(contextPath);
    %>

    <%!
        // 不能定义输出语句，这个代码块中只能定义转换后的类的成员变量、成员方法、静态代码块、非静态代码块。
//        System.out.println("hello JSP");
        private static Integer integer;
        private String string;
        public void method(){
            System.out.println("你好");
        }
    %>

    <%=
    // 打印输出上面定义的integer
        integer
    %>
</body>
</html>
