
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lqj
  Date: 2020/10/19
  Time: 2:11 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    /**
     * 在文件的开头,设置request编码,可以防止request.getParameter()获取中文乱码
     */
    request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
    <title>request demo</title>
</head>
<body>
<form action="reqeustdemo.jsp" method="get">
    请数输入姓名:<input type="text" name="name" />
    <input type="submit" value="确定" name="submit"/>
</form>
<%
    String submit=request.getParameter("submit");
    /**
     * 首次打开本页面submit为null
     * 判断submit是否为null,不为null,表示提交,null,表示没有提交`
     */
    if(submit!=null && submit.equals("确定")){
        out.print(request.getParameter("name"));
//        StudentDao studentDao = new StudentDaoImpl();
//        List<Student> allStudent = studentDao.getAllStudent();
        //把学生信息放入request中
        request.setAttribute("hello","hello world!");
        //页面跳转
        request.getRequestDispatcher("shows.jsp").forward(request,response);
    }
%>
</body>
</html>
