<%@ page import="java.sql.*" %>
<%@ page import="edu.njfu.dao.UserDao" %>
<%@ page import="edu.njfu.model.User" %>

<%--
  Created by IntelliJ IDEA.
  User: lqj
  Date: 2020/9/21
  Time: 3:25 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    //获取用户输入的用户名与密码
    String userName=request.getParameter("username");
    String password=request.getParameter("password");
    //创建UserDao对象
    UserDao userDao = new UserDao();
    //step6 遍历结果集
    if (userDao.checkLogin(new User(userName,password))){
        //out.print(resultSet.getString(1)+","+resultSet.getString(1)+","+resultSet.getString(1)+"<br>") ;
        session.setAttribute("user",userName);
        response.sendRedirect("njfu.jsp");
    }else{
        out.println("<script>alert('用户名密码错误!');location.href='login.html'</script>");
    }


%>
