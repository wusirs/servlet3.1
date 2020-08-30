package com.wu.web.case3_cookie;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/firstLogin")
public class firstLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
        String newLoginTime = sdf.format(new Date());

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("content-type", "text/html;charset=utf-8");

        newLoginTime = URLEncoder.encode(newLoginTime, "utf-8");
        Cookie cookie = new Cookie("id", newLoginTime);
        cookie.setMaxAge(60 * 60 * 24 * 30);
        resp.addCookie(cookie);

        System.out.println("firstLogin : ");

        String message = "欢迎登录您首次登录";
        resp.getWriter().write(message);
    }
}
