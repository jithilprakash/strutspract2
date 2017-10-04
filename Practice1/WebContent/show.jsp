<%@ page language="java" import="java.util.*,com.Entity.Good,com.Entity.User" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品展示页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <body>
      <h1>欢迎来到<%=(String)session.getAttribute("NowLogining")%>的购物车</h1>
       <s:form action="canlcelogin.action" method="get">
          <s:submit value="取消当前用户登录"/>
       </s:form>
   <table>
           <tr>
               <td>商品ID</td>
               <td>商品名字</td>
               <td>商品图片</td>
               <td>商品价格</td>
               <td>商品类型</td>
           </tr>
   <% 
       String  nowLogin= (String)session.getAttribute("NowLogining");
       List<Good> list = (List<Good>)session.getAttribute(nowLogin+"car");
       long totalPrice=0;
        if(list!=null&&list.size()>0){
           for(int i=0;i<list.size();i++){
               Good g= list.get(i);
               totalPrice=totalPrice+g.getGoodsPrice();
           %>
           <tr>
              <td><%=g.getGoodsId() %></td>
              <td><%=g.getGoodsName() %></td>
              <td><img src="<%=g.getGoodImg() %>" width="100" height="50"/></td>
              <td><%=g.getGoodsPrice() %></td>
              <td><%=g.getGoodType() %></td>
              </tr>
           <%
           }
       }
    %>
             </table>
         <s:a href="add.jsp" >添加购物车</s:a>
         <s:a href="delete.jsp" >删除购物车</s:a>
         <div class="totalPrice">
              
       <s:form action="totalPrice.action" method="get">
          <s:submit value="确认订单"/>
       </s:form>
    </div>
     <table border="1">  
    <tr>  
       <th>id</th>  
       <th>姓名</th>    
       <th>价格</th>
       <th>类型</th>  
    </tr>  
    <s:iterator value="Good">  
       <tr>  
          <td><s:property value="goodsId"/></td>  
          <td><s:property value="goodsName"/></td>  
          <td><s:property value="goodsPrice"/></td>  
          <td><s:property value="goodType"/></td>
       </tr>  
    </s:iterator>  
  </table>  
     <s:url id="url_pre" value="show.action">  
         <s:param name="pageNow" value="pageNow-1"></s:param>  
     </s:url>  
  
     <s:url id="url_next" value="show.action">  
         <s:param name="pageNow" value="pageNow+1"></s:param>  
     </s:url>    
  
     <s:a href="%{url_pre}">上一页</s:a>  
       
     <s:iterator value="good" status="status">  
        <s:url id="url" value="show.action">  
            <s:param name="pageNow" value="pageNow"/>  
        </s:url>  
     </s:iterator>  
  
     <s:a href="%{url_next}">下一页</s:a> 
  </body>
</html>
