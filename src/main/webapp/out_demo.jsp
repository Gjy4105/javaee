<%--
  Created by IntelliJ IDEA.
  User: lqj
  Date: 2020/10/13
  Time: 11:43 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>out对象demo</title>
</head>
<body>
   <%
       //1. out JSPWriter对象, flush
       out.print("hello world!<br>");
       out.write("软件工程18!<br>");
       //2. Console
       System.out.println("ere");
       out.flush();
   %>
<script>
    //3.
    document.write("这是javascript打印!<br>")
</script>
<%
    //4.
    response.getWriter().write("这是response getWrite()输出结果!<br>");
%>
</body>
</html>
