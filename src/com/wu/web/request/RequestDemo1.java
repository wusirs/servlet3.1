package com.wu.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1. 获取请求方式：GET
 *    String getMethod()
 * 2. **获取虚拟目录**：/web_1
 *    String getContextPath()
 * 3. 获取Servlet路径：/demo
 *    String getServletPath()
 * 4. 获取get方法请求参数：name=zhangsan
 *    String getQueryString()
 * 5. **获取请求的URI**：/web_1/demo
 *    String getRequestURI()：web_1/demo
 *    StringBuffer getRequestURL()：http://localhost/web_1/demo
 * 6. 获取协议及版本：HTTP1.1
 *    String getProtocol()
 * 7. 获取客户机的IP地址：
 *    String getRemoteAddr()
 */

@WebServlet("/RequestDemo1")
public class RequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求方式：GET
        String method = request.getMethod();
        System.out.print("获取请求方式：");
        System.out.println(method); // GET

        // 获取虚拟路径
        String contextPath = request.getContextPath();
        System.out.print("获取虚拟路径：");
        System.out.println(contextPath); // /web_project_1

        // 获取Servlet路径
        String servletPath = request.getServletPath();
        System.out.print("获取Servlet路径：");
        System.out.println(servletPath);// RequestDemo1

        // 获取get方式请求参数，name = zhangsan
        String queryString = request.getQueryString();
        System.out.print("获取get方式的请求参数：");
        System.out.println(queryString); // name = zhangsan

        // 获取请求URI：/web_project_1/RequestDemo1
        String requestURI = request.getRequestURI();
        System.out.print("获取URI：");
        System.out.println(requestURI); // /web_project_1/RequestDemo1

        // 获取URL：http://localhost/web_project_1/RequestDemo1
        StringBuffer requestURL = request.getRequestURL();
        System.out.print("获取URL：");
        System.out.println(requestURL); // http://localhost:8080/web_project_1/RequestDemo1

        // 获取协议版本：HTTP1.1
        String protocol = request.getProtocol();
        System.out.print("获取协议版本信息：");
        System.out.println(protocol); // HTTP/1.1

        // 获取客户机的IP地址：
        String remoteAddr = request.getRemoteAddr();
        System.out.print("获取客户机IP地址：");
        System.out.println(remoteAddr); // 0:0:0:0:0:0:0:1
    }
}
