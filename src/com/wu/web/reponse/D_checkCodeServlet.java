package com.wu.web.reponse;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

@WebServlet("/checkCodeServlet")
public class D_checkCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //验证码生成
        int width = 100;
        int height = 40;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.cyan);

        // 设置验证码背景
        graphics.fillRect(0,0, width, height);

        graphics.setColor(Color.BLACK);
        // 画边框
        graphics.drawRect(0, 0, width -1, height - 1);

        graphics.setColor(Color.RED);

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random ran = new Random();
        // 循环生成验证码画在图片上
        for (int i = 1; i < 5; i++) {
            int index = ran.nextInt(str.length());
            char ch = str.charAt(index);
            graphics.setFont(new Font("微软雅黑",Font.PLAIN, 20));
            graphics.drawString(ch + "" , width / 5 * i, (int)(height / 1.5));
        }

        //生成干扰线
        graphics.setColor(Color.black);
        for (int i = 0; i < 10; i++) {
            int x1 = ran.nextInt(width);
            int y1 = ran.nextInt(height);
            int x2 = ran.nextInt(width);
            int y2 = (int)(Math.sqrt((15 * 15) - Math.pow((x2 - x1),2))) + y1;
            graphics.drawLine(x1, y1, x2, y2);
        }

        // 相对路经所在地D:\Tomcat\apache-tomcat-8.5.54\bin
        File file = new File("ABCD2.jpg");
//        file.createNewFile();
        FileOutputStream fos = new FileOutputStream(file);
        ImageIO.write(image, "jpg", fos);
        fos.close();
        // 将图片输出到页面显示
        ImageIO.write(image, "jpg", resp.getOutputStream());
    }
}
