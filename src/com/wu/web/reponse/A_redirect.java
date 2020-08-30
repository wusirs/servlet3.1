package com.wu.web.reponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向：访问/redirect，会自动跳转/response_redirect资源
 */

@WebServlet("/redirect")
public class A_redirect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
//        // 1、设置状态码为302
//        resp.setStatus(302);
//        // 2、设置响应头location
//        resp.setHeader("location","/web_project_1/response_redirect");

        // 动态方式获取虚拟目录
        String contextPath = req.getContextPath();
        //这一步可以代替上面的1、2步
        resp.sendRedirect(contextPath+ "/response_redirect");
//        resp.sendRedirect("/web_project_1/response_redirect");
    }
}
