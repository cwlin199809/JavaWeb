package com.cwlin.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //this.getInitParameter(); 初始化参数
        //this.getServletConfig(); Servlet配置
        //this.getServletContext(); Servlet上下文

        ServletContext context = this.getServletContext();
        String username = "cwlin"; //数据
        context.setAttribute("username", username); //将一个数据保存在ServletContext中，键值对形式

        System.out.println("hello");
    }
}
