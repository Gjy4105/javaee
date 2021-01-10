<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: lqj
  Date: 2020/10/19
  Time: 2:36 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>responose demo</title>
</head>
<body>
 <%
     //1. 可以防止中文输出乱码
     response.setCharacterEncoding("UTF-8");
     //2. 输出
     PrintWriter writer = response.getWriter();
     writer.write("hello");
     writer.write("中国");
     //3. 页面跳转
     //response.sendRedirect("shows.jsp");
     //4. 页面刷新
     response.setHeader("refresh","1");
 %>
 <%=new Date()%>
</body>
</html>
