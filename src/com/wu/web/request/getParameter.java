package com.wu.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/getParameter")
public class getParameter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        System.out.println("get：" + username);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        System.out.println("post：" + username);
        System.out.println("--------------------");
        String[] hobbies = req.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobbies));
        System.out.println("--------------------");
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String element = parameterNames.nextElement();
            System.out.print(element + ": ");
            System.out.println(req.getParameter(element));
        }

        System.out.println("--------------------");
        Enumeration<String> parameterNames1 = req.getParameterNames();
        while (parameterNames1.hasMoreElements()) {
            String element = parameterNames1.nextElement();
            System.out.print(element + ": ");
            System.out.println(Arrays.toString(req.getParameterValues(element)));
        }

        System.out.println("--------------------");
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for (Map.Entry<String, String[]> entry: entries){
            System.out.println(entry.getKey() + ": " + Arrays.toString(entry.getValue()));
        }
    }
}
