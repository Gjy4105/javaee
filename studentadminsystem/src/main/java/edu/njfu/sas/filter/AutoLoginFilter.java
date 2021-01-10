package edu.njfu.sas.filter;


import edu.njfu.sas.dao.impl.UserDaoImpl;
import edu.njfu.sas.model.User;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Classname AutoLoginFilter
 * @Description TODO
 * @Date 2020/12/8 11:15 上午
 * @Created by lqj(1724226325@qq.com)
 */
public class AutoLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1. 把ServletRequest转换为HttpServletRequest
        HttpServletRequest request=(HttpServletRequest )servletRequest;
        //2.获取cookie,是保存在clinet端的key--value键值对,多个键值对组成数组
        Cookie[] cookies = request.getCookies();
        //3.在cookie查找key:autologin,把值保存到autoLogin中
        String autoLogin=null;
        for(Cookie c:cookies){
            if(c.getName().equalsIgnoreCase("autologin")){
                autoLogin=c.getValue();
            }
        }
        //4. 判断autoLogin是否为null ,null表示在cookie中没有找到,not null 找到
        if(autoLogin!=null){
           //自动登录
           //把真正的用户名与密码表示为:"zhangsan-123456"
            String[] users = autoLogin.split("-");
            User u=new User(users[0],users[1]);
            boolean result = new UserDaoImpl().checkLogin(u);
            if(result){
                //登录成功,把用户信息放入session中
                request.getSession().setAttribute("user",u);
            }
        }
        //放行
        filterChain.doFilter(request,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
