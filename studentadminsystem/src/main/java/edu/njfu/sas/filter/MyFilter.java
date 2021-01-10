package edu.njfu.sas.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Classname MyFilter
 * @Description TODO
 * @Date 2020/12/1 10:27 上午
 * @Created by lqj(1724226325@qq.com)
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String encoding = filterConfig.getInitParameter("encoding");
        String namespace = filterConfig.getInitParameter("namespace");
        System.out.println("MyFilter.init() is called!");
        System.out.println("--------"+encoding+"-------,-----"+namespace+"-------");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
//        System.out.println("MyFilter.doFilter() is called!");
        //检查用户是否已经登录,如果没有登录,跳转到登录页面
        //1.如何判断用户是否已经登录? session.getAttribute("user"),是否存在,
        //如果存在则认为用户已经登录,不存在用户没有登录
        //用户已经登录,不做任何处理,
        // 用户没有登录,跳转到登录页面
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        request.setCharacterEncoding("UTF-8");
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        Object user = session.getAttribute("user");
        if(user==null){
            PrintWriter writer = response.getWriter();
            System.out.println(request.getRequestURI());
            session.setAttribute("uri",request.getRequestURI());
            writer.write("<script>alert('用户未登录,请登录后再访问!');location.href='/login.html'</script>");
        }else{
            filterChain.doFilter(request,response);
        }

    }

    @Override
    public void destroy() {
        System.out.println("MyFilter.destroy() is called!");
    }
}
