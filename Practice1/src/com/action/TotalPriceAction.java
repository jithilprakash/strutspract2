package com.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.Entity.Good;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TotalPriceAction extends ActionSupport{
    private long  price;
    List<Good> list;
    
    
	public List<Good> getList() {
		return list;
	}

	public void setList(List<Good> list) {
		this.list = list;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
    @Override
    public String execute(){ 
    	this.setPrice(0);
    	HttpServletRequest req = ServletActionContext.getRequest();
    	Map session = ActionContext.getContext().getSession();
 	    String nowLogin =  (String) session.get("NowLogining");
    	List<Good> g = (List<Good>)req.getSession().getAttribute(nowLogin+"car");
    	if(g!=null)
    	for(Good t : g){
    		price=price+t.getGoodsPrice();
    	}
    	req.setAttribute("totalPrice", price);
    	return SUCCESS;
    }
}
