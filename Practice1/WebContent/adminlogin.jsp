<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
	
 .adminlogin{
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
   <script type="text/javascript">  
    function changeValidateCode(obj) {  
        var currentTime= new Date().getTime();  
        obj.src = "rand.action?d=" + currentTime;  
    }  
</script> 
  <body>
   <div class="adminlogin">
      <div class="form">
      <h1>欢迎来到管理员登录界面</h1>
      <s:form action="adminlogin.action" method="get">
      <table>
      <tr><s:textfield name="admin.adminname" label="用户名"></s:textfield><tr>
      <tr><s:password name="admin.adminpassword" label="密码"></s:password><tr>
      <tr><td><s:textfield name="admin.checklist" label="验证码"></s:textfield></td>
            <td><img src="rand.action" onclick="changeValidateCode(this)" /></td></tr>
      <tr></tr>
      <s:submit value="登录"></s:submit>  
      </table>
    </s:form>
      
      </div>
   </div>
  </body>
</html>
