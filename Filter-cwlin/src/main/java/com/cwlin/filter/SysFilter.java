package com.cwlin.filter;

import com.cwlin.util.Constant;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SysFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /*
            if(request.getSession().getAttribute(Constant.USER_SESSION).level == VIP1){
                response.sendRedirect("/vip1/index.jsp");
            }else if(request.getSession().getAttribute(Constant.USER_SESSION).level == VIP2){
                response.sendRedirect("/vip2/index.jsp");
            }else if(request.getSession().getAttribute(Constant.USER_SESSION).level == VIP3){
                response.sendRedirect("/vip3/index.jsp");
            }
         */

        //ServletRequest  HttpServletRequest
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if(request.getSession().getAttribute(Constant.USER_SESSION) == null){
            response.sendRedirect("/error.jsp");
        }

        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {}
}
