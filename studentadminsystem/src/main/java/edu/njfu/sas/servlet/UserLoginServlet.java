package edu.njfu.sas.servlet;

import edu.njfu.sas.dao.impl.UserDaoImpl;
import edu.njfu.sas.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userLoginServlet")
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //1. 获取用户名与密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);
        boolean result = new UserDaoImpl().checkLogin(user);
        //2. 验证
        if(result){
            // 3.成功后把用户密码,保存到session中
            request.getSession().setAttribute("user",user);
            //4. 创建cookie,设置存活期,设置保存路径,发送client端
            String autologin = request.getParameter("autologin");
            if(autologin!=null){
                Cookie cookie = new Cookie("autologin", username + "-" + password);
                //设置cookie的最大存活期
                cookie.setMaxAge(Integer.parseInt(autologin));
                //设置cookie的路径
                cookie.setPath(request.getContextPath());
                response.addCookie(cookie);
            }
            //跳转到首页,或者其他页面
            //1. 使用request
            //2. 使用response
            //3. 使用js

        }else{
            //给出提示,跳转到登录页面
        }

    }
}
