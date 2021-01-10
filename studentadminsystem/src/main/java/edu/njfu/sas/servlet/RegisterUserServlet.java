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

@WebServlet("/registerUser")
public class RegisterUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        Map map=new HashMap();
        //1.获取用户信息
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(username!=null && password!=null) {
            //2. 创建User对象
            User user = new User(username, password);
            UserDao dao = new UserDaoImpl();
            boolean result = dao.saveUser(user);
            if (result) {
                map.put("result","ok");
                map.put("msg","用户保存成功!");
            }else{
                map.put("result","false");
                map.put("msg","用户保存失败!");
            }
        }else{
            map.put("result","false");
            map.put("msg","用户保存失败!");
        }
        writer.write(new Gson().toJson(map));
    }
}
