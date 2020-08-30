package com.wu.web.cookie_and_session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getCookie")
public class A_getCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建cookie对象
        Cookie c = new Cookie("msg", "hello");

        /**
         * 设置cookie的存活时间，实现持久化存储，设置为
         * 整数：将Cookie数据写到硬盘的文件中，持久化存储，cookie存活时间，
         *      ，这个存活时间是指在浏览器关闭之后的时间，时间一过会自动删除cookie文件；
         * 负数：默认值，浏览器关闭cookie就没了；
         * 零：删除cookie信息；
         */
        c.setMaxAge(500);

        // 设置cookie共享，“/”为多个web项目可以共享。
        c.setPath("/");

        // 发送Cookie
        resp.addCookie(c);
    }
}
