<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>电商网站</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
   .login{
      position:absolute;
        background:url(image/back.jpg) no-repeat;
        height:700px;
        width:100%;
     }
     .form{
        postion:relative;
        margin-left:400px;
        margin-top:200px;
     }
    </style>
  </head>
  
  <body>
  <div class="login">
  <div class="form">
      <h1>欢迎来到电商网站</h1>
      <a href="login.jsp">用户登录</a>
      <a href="adminlogin.jsp">管理员登录</a>
      <a href="register.jsp">用户注册</a>
      <a href="adminregister.jsp">管理员注册</a>
      <br>
      <a href="upImage.jsp">上传用户头像</a>
  </div>
  </div>
    
  </body>
</html>
