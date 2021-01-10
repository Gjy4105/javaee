<%@ page import="java.util.Date" %>
<%@ page import="edu.njfu.model.User" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<body>
<h2>Hello World!</h2>
<!-- 这是HTML注释-->
<%--这是JSP注释--%>
<%
    //开始标记,结束标记,中间不能有空格
    out.print("hello world!") ;
    //int a=1/0;
    /**
     * 这是java多行注释
     */

%>
<%
    String name="张三";
    //控制台输出
    System.out.println(name);
    //页面输出
    out.print(name);
%>
<%!
    public void print(){
        System.out.print("hello world!") ;
    }
    //jsp声明,用于在jsp页面中声明一个方法,使用情况较少
%>
<%--jsp输出--%>
<%=new Date()%>
<%
    out.print("after date");
%>
<%--打印自定义对象--%>
<%
    User u=new User("张三","123456");
    out.print(u.toString());
    System.out.println(u);
%>
</body>
</html>
