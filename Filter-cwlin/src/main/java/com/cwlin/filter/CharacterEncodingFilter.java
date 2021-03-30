package com.cwlin.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    @Override //初始化
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharacterEncodingFilter初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override //销毁
    public void destroy() {
        System.out.println("CharacterEncodingFilter销毁");
    }
}
