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
    out.print("你输入的用户名与密码为:"+userName+":"+password);
%>
