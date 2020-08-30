package com.wu.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@WebServlet("/realPath")
public class getRealPath extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        String aPath = servletContext.getRealPath("/WEB-INF/classes/a.properties");
        File fileA = new File(aPath);
        System.out.println(aPath);
        System.out.println(fileA.isFile());

        String bPath = servletContext.getRealPath("/b.properties");
        File fileB = new File(bPath);
        System.out.println(bPath);
        System.out.println(fileB.exists());

        String cPath = servletContext.getRealPath("/WEB-INF/c.properties");
        File fileC = new File(cPath);
        System.out.println(cPath);
        System.out.println(fileC.exists());
    }
}
