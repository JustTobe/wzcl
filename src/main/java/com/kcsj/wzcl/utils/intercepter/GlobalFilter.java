package com.kcsj.wzcl.utils.intercepter;


import com.fasterxml.jackson.databind.util.JSONPObject;
import com.kcsj.wzcl.utils.TokenUtils;
import com.sun.xml.internal.bind.v2.TODO;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class GlobalFilter implements Filter {
    private static List<String> urlPaterrns;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        urlPaterrns = new ArrayList<>();
        //可以添加直接可访问的接口.
        urlPaterrns.add("/wzcl/login");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI();
        if(url.contains("login")||urlPaterrns.contains(url)){
            filterChain.doFilter(request,response);
            return;
        }
        String auth = request.getHeader("Authorization");

        boolean bool = TokenUtils.checkJWT(auth);
        if (bool) {
            filterChain.doFilter(request,response);
            return ;
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer= response.getWriter();
        writer.print("请先登陆");
        writer.flush();
        writer.close();
        return;
    }

    @Override
    public void destroy() {

    }

}
