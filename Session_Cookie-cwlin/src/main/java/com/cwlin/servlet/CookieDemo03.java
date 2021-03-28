package com.cwlin.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

//编码解码
public class CookieDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决中文乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        //Cookie, 服务器端从客户端获取
        Cookie[] cookies = req.getCookies(); //这里返回数组，说明Cookie可能存在多个
        PrintWriter out = resp.getWriter();
        //判断Cookie是否存在
        if (cookies != null) { //存在
            for (Cookie cookie : cookies) {
                //获取Cookie的名字
                if (cookie.getName().equals("name")) {
                    //System.out.println(cookie.getValue());
                    out.write(URLDecoder.decode(cookie.getValue(),"UTF-8")); //解码
                }
            }
        } else { //不存在
            out.write("这是您第一次访问本站");
        }
        Cookie cookie = new Cookie("name", URLEncoder.encode("码农","utf-8")); //编码
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
