package com.wu.web.cases;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User(username, password);
        UserDao ud = new UserDao();
        User loginUser = ud.login(user);
        if (loginUser == null){
            System.out.println("用户不存在！");
        } else {
            if (loginUser.getPassword().equals(password)){
                System.out.println("密码正确可以登录！");
                req.getRequestDispatcher("/successServlet").forward(req, resp);
            } else {
                req.setAttribute("user", user);
                req.getRequestDispatcher("/failServlet").forward(req, resp);
                System.out.println("密码错误登录失败！");
            }
        }
    }
}
