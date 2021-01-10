<%--
  Created by IntelliJ IDEA.
  User: lqj
  Date: 2020/10/20
  Time: 10:16 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page demo</title>
</head>
<body>
<%=page.hashCode()
%> <br>
<%=page%>
<%
    /**
     * 什么是hashcode?
     * 内存地址,经过hash函数后得到数值,叫作hashcode,是内存地址经过hash函数变换后的结果
     * hashcode作用是什么?
     * 为了快速查找对象,
     */
    /**
     * 作业:
     * 1.创建学生类,包含:stuNo,stuName,department三个属性.
     * 2. 重写Student类equals,hashcode方法,规定 只要 stuNo与StuName都相同,则认为这两个对象相等.
     *
     */
    /**
     * 通过page演示,jsp页面最终转换为java类,编译,执行,返回结果
     */
%>
</body>
</html>
