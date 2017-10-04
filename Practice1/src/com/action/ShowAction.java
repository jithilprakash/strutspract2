package com.action;

import java.util.List;
import java.util.Map;

import com.Entity.Good;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowAction extends ActionSupport{
     
	private List<Good> good;
	private int pageNow = 1;
	private int pageSize = 5;
	
	public List<Good> getGood() {
		return good;
	}
	public void setGood(List<Good> good) {
	   this.good = good;
	}
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public String execute() throws Exception{
		Map session = ActionContext.getContext().getSession();
		String name = (String) session.get("NowLogining");
		 good = (List<Good>) session.get(name+"car");
		 int from=0,to=good.size()>=5?4:good.size();
		 if(pageNow<0){
			 pageNow = 0;
		 }
	     while(pageNow>good.size()/5){
	    	 pageNow--;
	     }
	     if(good.size()>0){
	    	 from = pageNow *pageSize;
	    	 to = (from + pageSize)<good.size()?(from + pageSize):good.size();
	    	 good = good.subList(from , to);
	     }
		 return SUCCESS;
	}
}
