<%@ page import="edu.njfu.model.User" %>
<%@ page import="edu.njfu.dao.UserDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //获取用户名与密码
    String userName=request.getParameter("username");
    String password=request.getParameter("password");
    User user =new User(userName,password);
    //保存
    UserDao userDao = new UserDao();
    boolean result = userDao.saveUser(user);
    //根据保存的结果返回信息给用户
    if(result){
        //跳转到Success页面
        response.sendRedirect("success.jsp");
    }else{
        //跳转到error页面
        response.sendRedirect("error.jsp");
    }
%>