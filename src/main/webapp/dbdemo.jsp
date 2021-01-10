<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%--
  Created by IntelliJ IDEA.
  User: lqj
  Date: 2020/9/22
  Time: 11:26 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
   
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
    String sql="select * from tbl_user";
    //step4: 创建statement对象
    Statement statement=conn.createStatement();
    //step5: execute query ,return resultset object
    ResultSet resultSet = statement.executeQuery(sql);

    //step6 遍历结果集
    while (resultSet.next()){
        out.print(resultSet.getString(1)+","+resultSet.getString(2)+","+resultSet.getString(3)+"<br>") ;
        //out.print("hello");
    }


%>