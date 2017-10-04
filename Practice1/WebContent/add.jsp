<%@ page language="java" import="java.util.*,com.Entity.Good" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <style>
      .box{
        border:1px solid #ccc;
        height:100%;
        width:100%;
      }
      .box ul li{
         float:left;
         padding:5px
      }
      .show{
         position:absolute;
         margin-top:280;
         margin-left:300px;
         text-decoration:none;
         font-size:20px;
      }
      
  </style>
  <body>
  <div class="box">
     <ul>
        <li><img src="image/1.jpg"/><s:form action="add.action" method="get" namespace="/">
          <s:hidden name="param" value="1"/>
          <s:hidden name="type"  value="food"/>
          <s:hidden name="price"  value="5"/>
          <s:hidden name="name"  value="包子"/>
          <s:hidden name="img"  value="image/1.jpg"/>
        <s:submit value="添加到购物车"/>
        </s:form></li>
        <li><img src="image/2.jpg"/><s:form action="add.action" method="get" namespace="/">
           <s:hidden name="param" value="2" />
           <s:hidden name="type" value="food"/>
              <s:hidden name="price"  value="2"/>
          <s:hidden name="name"  value="馒头"/>
          <s:hidden name="img"  value="image/2.jpg"/>
        <s:submit value="添加到购物车"/>
        </s:form></li>
        <li><img src="image/3.jpg"/><s:form action="add.action" method="get" namespace="/">
           <s:hidden name="param" value="3"/>
           <s:hidden name="type" value="food"/>
            <s:hidden name="price"  value="1"/>
          <s:hidden name="name"  value="油条"/>
          <s:hidden name="img"  value="image/3.jpg"/>
        <s:submit value="添加到购物车"/>
        </s:form></li>
         <li><img src="image/4.jpg"/><s:form action="add.action" method="get" namespace="/">
           <s:hidden name="param" value="4"/>
           <s:hidden name="type" value="food"/>
            <s:hidden name="price"  value="8"/>
          <s:hidden name="name"  value="煎饼"/>
          <s:hidden name="img"  value="image/4.jpg"/>
        <s:submit value="添加到购物车"/>
        </s:form></li>
     </ul>
     <a href="show.jsp" class="show">展示我的购物车</a>
  </div>
  </body>
</html>
