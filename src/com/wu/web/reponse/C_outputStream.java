package com.wu.web.reponse;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/outputStream")
public class C_outputStream extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //字节输出同样要用设置头信息的方式先告诉客户端编码方式
        resp.setHeader("content-type","text/html;charset=utf-8");
        //获取字节输出流
        ServletOutputStream sos = resp.getOutputStream();
        // 打印输出
        //要用getBytes(charsetName)的方式获取字节流
        sos.write("你好".getBytes("utf-8"));
    }
}
