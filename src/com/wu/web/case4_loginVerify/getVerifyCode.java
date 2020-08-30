package com.wu.web.case4_loginVerify;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/verifyCode")
public class getVerifyCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  生成一个验证码图片，发送给客户端
        String alphabets = "abcdefghijklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        String verificationCode = "";
        BufferedImage image = new BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.PINK);
        graphics.fillRect(0, 0, 100, 30);
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("微软雅黑",Font.PLAIN, 25));
        for (int i = 0; i < 4; i++) {
            char c = alphabets.charAt(random.nextInt(alphabets.length()));
            graphics.drawString(c+"",100 / 5 * i + 15, (int)(30/1.3));
            verificationCode += c;
        }
        // 将随机到的验证码保存到session中
        HttpSession session = req.getSession();
        session.setAttribute("verifyCode", verificationCode);

        ImageIO.write(image, "jpg", resp.getOutputStream());
    }
}
