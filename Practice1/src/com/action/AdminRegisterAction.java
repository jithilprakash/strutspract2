package com.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.Entity.Admin;
import com.opensymphony.xwork2.ActionSupport;

public class AdminRegisterAction extends ActionSupport{
	private Admin admin;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String execute() throws UnsupportedEncodingException {
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse resp = ServletActionContext.getResponse();
		if (admin.getAdminname().length() > 0) {
			String username = new String(admin.getAdminname().getBytes(
					"ISO-8859-1"), "UTF-8");
			Cookie cs[] = req.getCookies();
			if (cs != null) {
				for (Cookie c : cs) {
					String name = URLDecoder.decode(c.getName(), "UTF-8");
					for (int i = 0; i < name.length(); i++) {
						if (name.charAt(i) == ':') {
							String value = URLDecoder.decode(c.getValue(),
									"UTF-8");
							if (name.equals(username)
									&& value.equals(admin.getAdminpassword())) {
								req.setAttribute("register_error",
										"用户已经存在不需要注册,请直接登录!");
								return "error";
							}
						}
					}
				}
			}
			addCookie(username + ":admin", admin.getAdminpassword());
			return "success";
		}
		req.setAttribute("register_error", "还没输入管理员账户");
		return "error";
	}

	private void addCookie(String name, String admin)
			throws UnsupportedEncodingException {
		name = URLEncoder.encode(name, "UTF-8");
		admin = URLEncoder.encode(admin, "UTF-8");
		Cookie cookie = new Cookie(name, admin);
		cookie.setMaxAge(60 * 60 * 24 * 365);
		ServletActionContext.getResponse().addCookie(cookie);
	}
} 
