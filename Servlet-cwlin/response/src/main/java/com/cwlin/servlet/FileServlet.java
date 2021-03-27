package com.cwlin.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取下载文件的路径
        String realPath = "E:\\硕士研究\\Java学习历程\\JavaWeb\\Servlet-cwlin\\response\\target\\classes\\qq头像.jpg";
        System.out.println("下载文件路径："+realPath);
        // 2. 获取下载的文件名
        String filename = realPath.substring(realPath.lastIndexOf("\\") + 1);
        // 3. 设置Content-Disposition使得浏览器能够支持下载我们需要的文件(注意是分号)
        // 中文文件名要用URLEncoder.encode进行编码，否则有课呢个乱码
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(filename,"utf-8"));
        // 4. 获取下载文件的输入流
        FileInputStream in = new FileInputStream(realPath);
        // 5. 创建缓冲区
        byte[] buffer = new byte[1024];
        // 6. 获取OutputStream对象
        int len;
        ServletOutputStream out = resp.getOutputStream();
        // 7. 将FileOutputStream流写入到buffer缓冲区，使用OutputStream将缓冲区中的数据输出到客户端！
        while((len=in.read(buffer))>0){
            out.write(buffer,0,len);
        }
        in.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
