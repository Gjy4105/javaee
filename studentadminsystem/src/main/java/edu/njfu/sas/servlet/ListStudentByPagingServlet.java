package edu.njfu.sas.servlet;

import com.google.gson.Gson;
import edu.njfu.sas.dao.impl.StudentDaoImpl;
import edu.njfu.sas.model.Student;
import edu.njfu.sas.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/listStudentsByPaging")
public class ListStudentByPagingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //1. 从web.xml文件中获取pageSize
        String pageSizeStr = request.getServletContext().getInitParameter("pageSize");
        int pageSize=10;
        if(pageSizeStr!=null){
          pageSize=Integer.parseInt(pageSizeStr);
        }
        //2. 获取page
        String pageStr = request.getParameter("page");
        int page=1;
        if(pageStr!=null){
           page=Integer.parseInt(pageStr);
        }
        //3.获取totalRecord,
        StudentDaoImpl studentDao = new StudentDaoImpl();
        Long  totalRecords=(Long)request.getSession().getAttribute("totalRecords");
        if(totalRecords==null){
            totalRecords=studentDao.totalRecords();
            request.getSession().setAttribute("totalRecords",totalRecords);
        }
        //4. 调整page
        page = new PageUtil(totalRecords, pageSize, page).getCurrentPage();
        //5.获取分页信息
        List<Student> studentByPaging = studentDao.getStudentByPaging(page, pageSize);
        //6. 设置response
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        //7. 写入
        writer.write(new Gson().toJson(studentByPaging));
        
    }
}
