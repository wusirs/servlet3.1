package com.wu.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/RequestGetHeader")
public class Request_getHeader extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> headerNames = req.getHeaderNames();
        // 遍历headerNames来获取请求头名称。
        while (headerNames.hasMoreElements()) {
            String element = headerNames.nextElement();
            // 通过请求头名获取请求值
            System.out.println(element + " : " + req.getHeader(element));
//            host : localhost:8080
//            connection : keep-alive
//            dnt : 1
//            upgrade-insecure-requests : 1
//            user-agent : Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.105 Safari/537.36
//            accept : text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
//            sec-fetch-site : none
//            sec-fetch-mode : navigate
//            sec-fetch-user : ?1
//            sec-fetch-dest : document
//            accept-encoding : gzip, deflate, br
//            accept-language : zh-CN,zh;q=0.9,en;q=0.8
//            cookie : JSESSIONID=F9F0639CCD687A633151652406568DA2; Webstorm-11b07291=db81d48e-e391-450c-9210-00d3f38decfe; Idea-ba1f60ca=b5a0bc54-b266-41b1-b5ff-b18c8040f6fd

        }
        String agent = req.getHeader("user-agent");
        System.out.println("user-agent：" + agent);
        if (agent.contains("Chrome")){
            System.out.println("这是一个Chrome浏览器！");
        }

        if (agent.contains("Safari")) {
            System.out.println("这是Safari浏览器");
        }

        if (agent.contains("Firefox")){
            System.out.println("这是Firefox浏览器");
        }

        if(agent.contains("Edge")){
            System.out.println("这是Edge浏览器");
        }

        System.out.println("______________________");
        String referer = req.getHeader("referer");
        System.out.println(referer);
        if (referer != null) {
            resp.setContentType("text/html;charset=utf-8");
            if (referer.contains("http://localhost:8080/web_project_1/login.html")){
                System.out.println("从正常路径来的可以正常获取资源！");
                resp.getWriter().write("正常获取资源！");
            }else {
                System.out.println("盗链，非法途径不能正常获取资源！");
                resp.getWriter().write("这是盗链，不给你资源！");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
