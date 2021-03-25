package com.cwlin.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/* 注意Tomcat10和Tomcat9的区别：
tomcat10有个最大的变动就是Tomcat 10 m1将JavaEE也换成了Jakarta® EE
Jakarta® EE较以前的JavaEE有一个非常非常重要的更新：
包名不再是"javax.servlet.“而是改成了"jakarta.servlet.”
*/
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //响应的类型：html
        resp.setContentType("text/html");
        //网页编码：utf-8
        resp.setCharacterEncoding("utf-8");
        //获取响应的输出流
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello World! 我是 cwlin!</h1>");
        out.println("</body>");
        out.println("</html>");
        //super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
