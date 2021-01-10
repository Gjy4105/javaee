<%--
  Created by IntelliJ IDEA.
  User: lqj
  Date: 2020/10/20
  Time: 11:08 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp action</title>
</head>
<body>
     <%
         //jsp:include
         //jsp:forward
     %>
<%--<jsp:include page="logo.jsp"  />--%>
<%--<jsp:include page="adv.jsp" />--%>
<%--     <jsp:include page="main.jsp" />--%>
<%--<jsp:include page="footer.jsp"/>--%>
<%
    /**
     * jsp:include 与 page include
     * 1. 功能相同
     * 2. 区别:
     *  include指令是一个静态包含,包含文件与被包含文件合并后组成一个新文件进行编译执行
     *  include动作,是一个动态包含,程序执行到包含文件时才动态的引入,包含文件与被包含文件是两个实体.
     */
%>
<%
    /**
     * jsp forward 可以直接跳转到其他页面
     */
    
%>
<jsp:forward page="http://localhost:8080/jspactiondemo.jsp"></jsp:forward>
<%
    /**
     * 作业:
     *  1. jsp:forward 中文乱码,怎么解决?
     *  2. jsp: forward page只能为相对路径,不能使用http,或者是绝对路径
     */
%>
</body>
</html>
