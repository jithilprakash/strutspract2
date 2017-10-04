package com.action;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.Entity.User;
import com.dao.JdbcUtil;
import com.opensymphony.xwork2.ActionSupport;
public class RegisterAction extends ActionSupport{
    private User user;
    @Override
    public String execute() throws UnsupportedEncodingException, SQLException{
    	JdbcUtil jdbcUtil = new JdbcUtil();
		Connection conn = jdbcUtil.getConnection();
		Statement stmt=null;
		if(conn!=null)
			stmt =conn.createStatement();
		ResultSet rt = null;
		HttpServletRequest req = ServletActionContext.getRequest();
		String username = new String(user.getUsername().getBytes("ISO-8859-1"),"UTF-8");
    	Cookie cs[] = req.getCookies();
    	if(user.getUsername().length()>0){
    	if(cs!=null){
    	for(Cookie c:cs){
    		String name = URLDecoder.decode(c.getName(),"UTF-8");
     		String value = URLDecoder.decode(c.getValue(),"UTF-8");
    		if(name.equals(username)&&value.equals(user.getPassword())){
    		    req.setAttribute("register_error","用户已经存在不需要注册,请直接登录!");
    			return "error";
    		}
    	}
    	}
    	String a = "";
    	addCookie(username,user.getPassword());
    	String sql = "insert into user(username,password,checklist) values('"+username+"','"+user.getPassword()+"','"+a+"')";
    	int n=0;
    	if(stmt!=null)
	    n= stmt.executeUpdate(sql);
	    if(n==0){
	    	req.setAttribute("register_error","用户输入不成功!");
	    	return "error";
	    }
    	}
    	return "success";
    }
    private void addCookie(String name,String user2) throws UnsupportedEncodingException{
        name = URLEncoder.encode(name,"UTF-8");
		user2 = URLEncoder.encode(user2,"UTF-8");
        Cookie cookie = new Cookie(name, user2);
        cookie.setMaxAge(60*60*24*365);
        ServletActionContext.getResponse().addCookie(cookie);
    }
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
