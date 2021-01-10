<%--
  Created by IntelliJ IDEA.
  User: lqj
  Date: 2020/10/13
  Time: 11:35 上午
  To change this template use File | Settings | File Templates.
--%>
<%
    String userName=(String)session.getAttribute("user");
    if(userName==null){
        out.print("<script>alert('非法访问!');location.href='login.html'</script>");
    }else{

%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="logo.jsp"%>
<%@ include file="adv.jsp"%>
<%@ include file="main.jsp"%>
<%@ include file="footer.jsp"%>
<%
    }
%>