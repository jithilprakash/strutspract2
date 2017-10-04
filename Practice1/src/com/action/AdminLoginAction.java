package com.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.Entity.Admin;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdminLoginAction extends ActionSupport{
     private Admin admin;
     private String prePage;// 登录前页面  
     
	public String getPrePage() {
		return prePage;
	}

	public void setPrePage(String prePage) {
		this.prePage = prePage;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
     
    @Override
    public String execute() throws UnsupportedEncodingException{
    	HttpServletRequest req = ServletActionContext.getRequest();
		String check = (String) req.getSession().getAttribute("rand");
		
		   ActionContext ctx = ActionContext.getContext();  
           Map<String, Object> session = ctx.getSession();  
       	if(!admin.getChecklist().equals(check)){
			req.setAttribute("login_error", "验证码输入不正确，请重新输入");
			return "error";
		}
       	if(admin.getAdminname().length()>0){
       		String username = new String(admin.getAdminname().getBytes("ISO-8859-1"),"UTF-8");
       		//是否有删除用户的权利
       		admin.setCancel(true);
	    	HttpServletResponse resp = ServletActionContext.getResponse();
	    	Cookie cs[] = req.getCookies();
	    	if(cs!=null){
	    	for(Cookie c:cs){
			String name = URLDecoder.decode(c.getName(),"UTF-8");
     		String value = URLDecoder.decode(c.getValue(),"UTF-8");
    		if(name.equals(username+":admin")&&value.equals(admin.getAdminpassword())){
    			    session.put("adminLogin", admin);
                     return "success";
		    }
	    	}
		}
		}
		req.setAttribute("login_error", "没有该用户请先去注册");
			return "error";
    }
}
