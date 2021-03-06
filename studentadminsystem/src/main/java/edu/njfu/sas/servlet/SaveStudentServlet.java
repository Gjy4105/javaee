package edu.njfu.sas.servlet;

import com.google.gson.Gson;
import edu.njfu.sas.dao.StudentDao;
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

@WebServlet(urlPatterns = "/add")
public class SaveStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //使用doPost处理保存学生请求
        //1. 获取学生信息
        //2. 创建学生对象
        //3.调用StudentDao.saveStudent(student)方法保存学生信息
        //4. 根据返回结果,进行页面跳转
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
        boolean result=sdao.saveStudent(student);
        sdao.updategender();
        HashMap<String,String> map=new HashMap<String, String>();
        if(result){
            map.put("result","保存成功");
            map.put("msg","ok");
            request.getRequestDispatcher("liststudents.jsp").forward(request, response);
        }else{
            map.put("result","保存失败");
            map.put("msg","error");
        }
        PrintWriter out=response.getWriter();
        out.write(new Gson().toJson(map));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
