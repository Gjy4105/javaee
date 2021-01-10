package edu.njfu.sas.servlet;

import com.google.gson.Gson;
import edu.njfu.sas.dao.impl.StudentDaoImpl;
import edu.njfu.sas.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/updateUserInfo")
public class UpdateUserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取用户与学生信息
        //2. 创建学生表
        //3.更新用户信息
        //4.保存学生信息
        //5.输出,成功或者失败
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String stuno=request.getParameter("stuno");
        String stuname=request.getParameter("stuname");
        String classes=request.getParameter("classes");
        String gender=request.getParameter("gender");
        String department=request.getParameter("department");
        String tel=request.getParameter("tel");
        String dormno=request.getParameter("dormno");
        Student student=new Student(stuno,stuname,classes,gender,department,tel,dormno,null);
        StudentDaoImpl sdao=new StudentDaoImpl();
        boolean result=sdao.delStudent(stuno);
        sdao.saveStudent(student);
        sdao.updategender();
        HashMap<String,String> map=new HashMap<String, String>();
        if(result){
            map.put("result","更新成功");
            map.put("msg","ok");
            request.getRequestDispatcher("liststudents.jsp").forward(request, response);
        }else{
            map.put("result","更新失败");
            map.put("msg","error");
        }
        PrintWriter out=response.getWriter();
        out.write(new Gson().toJson(map));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
