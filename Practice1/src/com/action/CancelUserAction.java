package com.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class CancelUserAction extends ActionSupport{
	@Override
	public String execute() throws UnsupportedEncodingException {
		HttpServletRequest req = ServletActionContext.getRequest();
		String username = req.getParameter("id");
		System.out.println("1:" + username);
		if (username.length() > 0) {
			Cookie cs[] = req.getCookies();
			if (cs != null) {
				for (Cookie c : cs) {
					String name = URLDecoder.decode(c.getName(), "UTF-8");
					System.out.println("2:" + name);
					String value = URLDecoder.decode(c.getValue(), "UTF-8");
					if (name.equals(username)) {
						System.out.println("可以删除用户了!");
						Cookie cookie = new Cookie(c.getName(), c.getValue());
						cookie.setMaxAge(0);
						ServletActionContext.getResponse().addCookie(cookie);
						return SUCCESS;
					}
				}
			}
		}
		return SUCCESS;
	}
}
