package com.wu.web.reponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/write_print")
public class B_write extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 在获取流之前设置response的编码，默认编码为ISO-8859-1
//        System.out.println(resp.getCharacterEncoding());
//        resp.setCharacterEncoding("utf-8");
        //先通过设置响应头中的content-type的信息告诉客户端response的编码方式可以完美的避开乱码
//        resp.setHeader("content-type","text/html;charset=utf-8");
        // 写法二
        resp.setContentType("text/html;charset=utf-8");

        // 获取输出流
        PrintWriter pw = resp.getWriter();
        // 打印输出到客户端
//        pw.write("<h1>hello response</h1>");
        pw.write("你好啊,世界");
    }
}
