package com.action;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import com.Entity.Good;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteAction extends ActionSupport{
	List<Good> list;
	private int pageNum;
	private int pageIndex;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public List<Good> getList() {
		return list;
	}

	public void setList(List<Good> list) {
		this.list = list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws UnsupportedEncodingException {
		Map session = ActionContext.getContext().getSession();
		String name = (String) session.get("NowLogining");
		list = (List<Good>) session.get(name + "car");
		System.out.println(pageNum + ":" + pageIndex);
		if (list != null)
			list.remove(list.get((pageNum - 1) * 5 + pageIndex - 1));
		session.put("car", list);
		return "success";
	}
}
