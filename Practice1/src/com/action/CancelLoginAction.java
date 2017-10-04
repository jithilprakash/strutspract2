package com.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.Entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CancelLoginAction extends ActionSupport{
	private static final long serialVersionUID = 8013816027944871760L;
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws UnsupportedEncodingException {
		Map session = ActionContext.getContext().getSession();
		HttpServletRequest req = ServletActionContext.getRequest();
		String nowLogin = (String) session.get("NowLogining");
		System.out.println("当前用户是" + nowLogin);
		if (nowLogin.length() > 0) {
			Cookie cs[] = req.getCookies();
			if (cs != null) {
				for (Cookie c : cs) {
					String name = URLDecoder.decode(c.getName(), "UTF-8");
					String value = URLDecoder.decode(c.getValue(), "UTF-8");
					if (name.equals(nowLogin)) {
						Cookie cookie = new Cookie(c.getName(), c.getValue());
						c.setMaxAge(0);
						ServletActionContext.getResponse().addCookie(cookie);
						req.removeAttribute("NowLogining");
						return SUCCESS;
					}
				}
			}
		}
		req.setAttribute("login_error", "当前没有用户登录");
		return "error";
	}
}
