package com.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {  
	  
    private static final long serialVersionUID = 4956767125951165062L;  
  
    // 拦截Action处理的拦截方法  
    public String intercept(ActionInvocation invocation) throws Exception {  
  
        // 取得请求相关的ActionContext实例  
        ActionContext ctx = invocation.getInvocationContext();  
        Map<String, Object> session = ctx.getSession();   
        // 取出名为user的Session属性  
        String user = (String) session.get("userLogin");  
  
        // 如果已经有用户登录，放行  
        if (user != null ) {  
        	System.out.println("用户登录了！");
            return invocation.invoke();  
        }  
  
        // 获取HttpServletRequest对象  
        HttpServletRequest req = ServletActionContext.getRequest();  
  
        // 获取此请求的地址  
        String path = req.getRequestURI();  
        System.out.println("path:" + path);  
        // 存入session，方便调用  
        session.put("prePage", path);  
    
        // 直接返回login的逻辑视图  
        return "begin";  
    }  
}  
