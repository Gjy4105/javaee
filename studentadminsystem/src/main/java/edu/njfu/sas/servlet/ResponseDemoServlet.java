package edu.njfu.sas.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/responseTest")
public class ResponseDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         resp.setContentType("text/html;charset=utf-8");
         resp.setCharacterEncoding("UTF-8");
//         //字符流
//        PrintWriter writer = resp.getWriter();
//        writer.write("hello world");
        //字节流
        ServletOutputStream out = resp.getOutputStream();
        out.write("<br>软件工程18".getBytes());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
