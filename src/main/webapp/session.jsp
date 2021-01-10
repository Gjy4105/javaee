<%--
  Created by IntelliJ IDEA.
  User: lqj
  Date: 2020/10/19
  Time: 2:56 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>session demo</title>
</head>
<body>
     <%
         /**
          * 用户与服务器的一次交互,有时间限制,通常30分钟
          * setAttribute()
          * getAtribute()
          */
         session.setAttribute("hello2","hello session!");
         response.sendRedirect("shows2.jsp");
         /**
          * 使用session可以做到防盗链功能
          * 只有认证用户可以访问,非认证用户不可以访问
          * 强制访问,给出提示,跳转到登录页面
          */
     %>
</body>
</html>
