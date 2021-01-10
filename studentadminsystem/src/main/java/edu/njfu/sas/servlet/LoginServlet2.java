package edu.njfu.sas.servlet;

import com.google.gson.Gson;
import edu.njfu.sas.dao.UserDao;
import edu.njfu.sas.dao.impl.UserDaoImpl;
import edu.njfu.sas.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/userLogin2")
public class LoginServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        Map map=new HashMap();
        //1.获取用户输入
        String userName=request.getParameter("username");
        String password=request.getParameter("password");
        if(userName!=null && password!=null) {
            //2.创建对象
            User u=new User(userName,password);
            //3.验证密码
            UserDao userDao = new UserDaoImpl();
            boolean result = userDao.checkLogin(u);
            if(result){
               //1. 把用户信息保存到session中
                request.getSession().setAttribute("user",u);
                //2.跳转到到listStudent页面
                String uri=(String)request.getSession().getAttribute("uri");
                System.out.println("--session uri:----"+uri+"+++++++++");
                if(uri!=null){
                    request.getRequestDispatcher(uri).forward(request,response);
                    System.out.println("uri is not null");
                }else {
                    System.out.println("uri is null");
                    request.getRequestDispatcher("liststudents.jsp").forward(request, response);
                }
            } {
                //用户名密码错误
//                提示信息并返回到登录页面
                writer.write("<script>alert('用户未登录,请登录后再访问!');location.href='login.html'</script>");
            }
        } else{
            writer.write("<script>alert('用户未登录,请登录后再访问!');location.href='login.html'</script>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }
}
