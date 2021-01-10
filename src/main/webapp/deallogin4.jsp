<%@ page import="java.sql.*" %>

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
    //连接数据库
    /**
     * Connection 对象 ,用户不能通过new创建
     * 
     */
      //step1: register driver
    Class.forName("com.mysql.cj.jdbc.Driver");
    //step2. 获取Conection对象
    /**
     * 三个参数
     *  1. url: "jdbc:mysql://ip:port/dbname"
     *  2. username
     *  3. password
     */
    String url="jdbc:mysql://localhost:3306/software18";
    String dbName="root";
    String dbPassword="12345678";   //改为自己mysql数据库密码
    Connection conn = DriverManager.getConnection(url,dbName,dbPassword);
    //step3: 获取什么数据?编写sql
    //String sql="select * from tbl_user";
    String sql1="select * from tbl_user where username=? and password=?";
    //step4: 创建statement对象
    //Statement statement=conn.createStatement();
    PreparedStatement preparedStatement = conn.prepareStatement(sql1);
    //assign value for placeholder
    preparedStatement.setString(1,userName);
    preparedStatement.setString(2,password);
    //step5: execute query ,return resultset object
    ResultSet resultSet = preparedStatement.executeQuery(sql1);

    //step6 遍历结果集
    if (resultSet.next()){
        //out.print(resultSet.getString(1)+","+resultSet.getString(1)+","+resultSet.getString(1)+"<br>") ;
        out.println("用户名密码正确");
    }else{
        out.println("用户名密码错误!");
    }


    // out.print("你输入的用户名与密码为:"+userName+":"+password);
//    if(userName!=null && userName.equals("zhangsan")){
//        if(password!=null && password.equals("123456")){
//            out.print("用户名与密码正确");
//        }else{
//            out.print("密码错误");
//        }
//    }else{
//        out.print("用户名错误!");
//    }
%>
