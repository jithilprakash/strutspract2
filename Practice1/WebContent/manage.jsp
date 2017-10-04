<%@ page language="java" import="java.util.*,java.net.URLDecoder;" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
.manage{
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
  <div class="manage">
  <div class="form">
    <h1>欢迎来到后台管理员界面</h1> <br>
    <% Cookie[] users = request.getCookies();
       if(users!=null){
          %>
             <table>
               <tr>
                   <td>用户姓名</td>
                   <td>用户密码</td>
                   <td>是否删除用户</td>
               </tr>
             <%
                for(Cookie s :users){
                int flag=0;
                	String name = URLDecoder.decode(s.getName(),"UTF-8");
                	for(int i=0;i<name.length();i++){
                	char ch = name.charAt(i);
                	if(ch==':'){
                	  flag=1;
                	}
                	}
                	if(flag==1){
                	continue;
                	}
                	if(name.equals("JSESSIONID")){
                	continue;
                	}
     		String value = URLDecoder.decode(s.getValue(),"UTF-8");
     		if(s.getValue()=="-1"){
     		continue;
     		}
                   %>
                      <tr>
                        <td><%=name %></td>
                        <td><%=value %></td>
                        <td><form action="cancelUser.action"
                          method="post">
                          <input type="hidden" name="id" value="<%=name %>">
                          <input type="submit" value="删除"/>
                          </form></td>
                      </tr>
                   <% 
                }
                %>
                    </table>
          <%
       }
    %>
    <a href="index.jsp">回到首页</a>
    </div>
    </div>
  </body>
</html>
