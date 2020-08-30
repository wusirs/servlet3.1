package com.wu.web.cookie_and_session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getCookie1")
public class A_getCookie1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取cookie
        Cookie[] cookies = req.getCookies();

        // 遍历cookies
        if(cookies != null){
            for (Cookie c: cookies
                 ) {
                String name = c.getName();
                String value = c.getValue();
                System.out.println(name + ": " + value);
            }
        }
    }
}
