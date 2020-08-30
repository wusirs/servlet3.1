package com.wu.web.case4_loginVerify;

import com.wu.web.cases.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        // 先判断验证码是否正确
        HttpSession session = req.getSession();
        String verifyCode = (String)session.getAttribute("verifyCode");
        System.out.println(verifyCode);
        Map<String, String[]> parameterMap = req.getParameterMap();
        String inputVerify = parameterMap.get("verifyCode")[0];
        session.removeAttribute("verifyCode");
//        System.out.println(inputVerify);
        boolean verifyResult = false;
        if (verifyCode == null || verifyCode.equals("") || inputVerify == null || !inputVerify.equals("")){
            verifyResult = false;
        }

        if (verifyCode != null) {
            verifyResult = verifyCode.equalsIgnoreCase(inputVerify);
        }
        session.setAttribute("verifyResult", verifyResult);

        // 验证码正确开始验证用户名和密码是否正确
        String name = parameterMap.get("account")[0];
        String password = parameterMap.get("password")[0];
        User user = new User(name, password);

        UserService userService = new UserService();
        try {
            if (verifyResult == false)
                throw new Exception("验证码不正确");
            userService.login(user);
            // 登录成功，把用户信息存到session中，重定向页面
            session.setAttribute("userObject", user);
            resp.sendRedirect(req.getContextPath() + "/case4_loginVerify/success.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("userVerify", e.getMessage());
            System.out.println("返回");
            req.getRequestDispatcher("/case4_loginVerify/login.jsp").forward(req,resp);
//            resp.sendRedirect("/Servlet2/case4_loginVerify/login.jsp");
        }
    }
}
