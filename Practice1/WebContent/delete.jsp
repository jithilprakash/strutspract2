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
    
    <title>My JSP 'delete.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <style>
     .delete{
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
   <div class="delete">
      <div class="form">
          <s:form action="delete.action" method="get">
             <s:textfield name="pageNum" label="輸入刪除的商品所处页数"/>
               <s:textfield name="pageIndex" label="輸入刪除的商品所处页数的位置"/>
             <s:submit value="確認"/>
          </s:form>
      </div>   
   </div>
  </body>
</html>
