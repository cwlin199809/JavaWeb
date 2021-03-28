package com.cwlin.servlet;

import com.cwlin.pojo.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;

//使用Session
public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决中文乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        //获取Session
        HttpSession session = req.getSession();

        //给Session存东西
        session.setAttribute("name",new Person("码农",1));

        //获取Session的ID
        String sessionId = session.getId();

        //判断Session是不是新创建的
        if (session.isNew()) {
            resp.getWriter().write("Session创建成功，sessionId: "+sessionId);
        }else {
            resp.getWriter().write("Session已经在服务器中存在，sessionId: "+sessionId);
        }

        /*Session创建的时候做了什么事情：
            Cookie cookie = new Cookie("JSESSIONID", sessionId);
            resp.addCookie(cookie);
         */
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
