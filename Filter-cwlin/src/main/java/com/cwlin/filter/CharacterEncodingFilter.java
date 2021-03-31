package com.cwlin.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    @Override //初始化：web服务器启动，就已经初始化了，随时等待过滤对象出现！
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharacterEncodingFilter初始化");
    }

    /*filterChain: 链
        1. 过滤中的所有代码，在过滤特定请求的时候都会执行
        2. 必须要让过滤器继续执行
            chain.doFilter(request,response);
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=UTF-8");

        System.out.println("CharacterEncodingFilter执行前");
        filterChain.doFilter(servletRequest, servletResponse); //让我们的请求继续往下走，如果不写，程序到这里就被拦截停止了！
        System.out.println("CharacterEncodingFilter执行后");
    }

    @Override //销毁：web服务器关闭的时候，过滤器会被销毁
    public void destroy() {
        System.out.println("CharacterEncodingFilter销毁");
    }
}
