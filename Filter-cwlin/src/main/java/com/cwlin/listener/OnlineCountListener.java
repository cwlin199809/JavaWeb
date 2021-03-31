package com.cwlin.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

//统计网站在线人数，即统计Session
public class OnlineCountListener implements HttpSessionListener {
    @Override //创建Session监听，一旦创建Session就会触发一次这个时间
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ServletContext context = httpSessionEvent.getSession().getServletContext();
        Integer onlineCount = (Integer) context.getAttribute("OnlineCount");
        if (onlineCount == null){
            onlineCount = 1;
        }else{
            onlineCount++;
        }
        context.setAttribute("OnlineCount", onlineCount);
    }

    @Override //销毁Session监听，一旦销毁Session就会触发一次这个时间
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext context = httpSessionEvent.getSession().getServletContext();
        Integer onlineCount = (Integer) context.getAttribute("OnlineCount");
        if (onlineCount == null){
            onlineCount = 0;
        }else{
            onlineCount--;
        }
        context.setAttribute("OnlineCount", onlineCount);
    }
}
