package com.wu.web.cookie_and_session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/getAttribute")
public class B_Session_getAttribute extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 利用session获取数据
        HttpSession session = req.getSession();
        // 获取数据
        Object msg = session.getAttribute("msg");
        long creationTime = session.getCreationTime();

        System.out.println(msg);
        System.out.println(creationTime);
    }
}
