<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminregister.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
  .adminregister{
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
 <div class="adminregister">
      <div class="form">
      <h1>管理员注册页面</h1>
    <s:form method="get" action="adminregister.action">
       <s:textfield name="admin.adminname" label="用户名"/>
       <s:password name="admin.adminpassword" label="密码"/>
       <s:submit value="注册"/>
    </s:form>
     <s:a href="register.jsp">用户注册界面</s:a>  
    </div>
    </div>
  </body>
</html>
