package com.wu.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestDispatcher")
public class RequestDispatcher extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("\\RequestDispatcher已接受");
        System.out.println("正在转发 ...");
        System.out.println("转发内容如下：");
        req.setAttribute("msg", "你好get！");
        req.getRequestDispatcher("/RequestDispatcher1").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("\\RequestDispatcher已接受");
        System.out.println("正在转发 ...");
        System.out.println("转发内容如下：");
        req.setAttribute("msg", "你好post！");
        req.getRequestDispatcher("/RequestDispatcher1").forward(req, resp);
    }
}
