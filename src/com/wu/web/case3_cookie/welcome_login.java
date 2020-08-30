package com.wu.web.case3_cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 案例：记住上一次访问时间
 * 访问一个Servlet，如果是第一次访问，则提示：你好，欢迎您首次登录
 * 如果不是第一次访问，则提示：欢迎回来，你上次访问时间为：显示时间字符串
 */

@WebServlet("/welcomeLogin")
public class welcome_login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        // 获取用户id信息
        String id = req.getParameter("id");
        Cookie[] cookies = req.getCookies();

        int index = 0;
        if(cookies != null){
            for (index = 0; index < cookies.length; index++) {
                if ("lastTime".equals(cookies[index].getName())){
                    String loginTime = cookies[index].getValue();
                    loginTime = URLDecoder.decode(loginTime, "utf-8");
                    // 不是第一次登录

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String newLoginTime = sdf.format(new Date());
                    newLoginTime = URLEncoder.encode(newLoginTime, "utf-8");
                    cookies[index].setValue(newLoginTime);
                    cookies[index].setMaxAge(60*60*24*30);
                    resp.addCookie(cookies[index]);

                    resp.getWriter().write("欢迎再次登录：" + loginTime);
                    break;
                }
            }
        }

        if (cookies == null || index == cookies.length){
            // 第一次登录
//            String contextPath = req.getContextPath();
//            resp.sendRedirect(contextPath + "/firstLogin");


            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String newLoginTime = sdf.format(new Date());
            newLoginTime = URLEncoder.encode(newLoginTime, "utf-8");
            Cookie cookie = new Cookie("lastTime", newLoginTime);
            cookie.setMaxAge(60*60*24*30);
            resp.addCookie(cookie);

            resp.getWriter().write("欢迎首次登录");
        }
    }
}
