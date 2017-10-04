package com.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.Entity.Good;
import com.Entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddAction extends ActionSupport{
	private String param;
	private String type;
	private String img;
	private long price;
	private String name;
	List<Good> list;

	public List<Good> getList() {
		return list;
	}

	public void setList(List<Good> list) {
		this.list = list;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws UnsupportedEncodingException {
		Map session = ActionContext.getContext().getSession();
		String nowLogin = (String) session.get("NowLogining");
		System.out.println("当前用户:" + nowLogin + "正在购买商品");
		if (nowLogin != null)
			list = (List<Good>) session.get(nowLogin + "car");
		if (list == null) {
			list = new ArrayList<Good>();
		}
		name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
		Good good = new Good(param, name, price, img, type);
		list.add(good);
		session.put(nowLogin + "car", list);
		return "success";
	}
}
