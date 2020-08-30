package com.wu.web.case2;

import com.wu.web.util.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/download")
public class download extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取要下载的文件的文件名
        String filename = req.getParameter("filename");

        // 获取context对象
        ServletContext servletContext = this.getServletContext();

        // 获取真实路径
        String realPath = servletContext.getRealPath("/img/" + filename);

        // 获取输入字节流
        FileInputStream fis = new FileInputStream(realPath);

        // 解决文件名在下载提示框中文乱码问题
        String agent = req.getHeader("user-agent");
        filename = DownLoadUtils.getFileName(agent, filename);

        // 设置响应头，默认以附件的方式下载打开
        // 1、设置响应头类型content-type
        // 获取文件的mimetype
        String mimeType = servletContext.getMimeType(filename);
        resp.setHeader("content-type", mimeType);
        // 2、设置响应头打开方式：content-disposition
        // 这里的filename是下载提示框展示的文件名
        resp.setHeader("content-disposition", "attachment;filename=" + filename);

        // 通过输出流写数据
        ServletOutputStream sos = resp.getOutputStream();

        int len = -1;
        byte[] bs = new byte[1024];
        while ((len = fis.read(bs)) != -1) {
            sos.write(bs, 0, len);
        }

        fis.close();
    }
}
