<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	out.println("hell world!<br>software 18!");
    //打印九九乘法表
    for(int i=1;i<=9;i++){
    	for(int j=1;j<=i;j++){
    		out.print(i+"*"+j+"="+i*j+"&nbsp;&nbsp;");
    	}
    	out.print("<br>");
    }
    //jsp 可以使用page指令自定义错误处理页面
%>
</body>
</html>