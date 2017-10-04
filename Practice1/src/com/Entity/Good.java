package com.Entity;

import java.io.Serializable;

public class Good implements Serializable{
	   public String goodsId;
	   public String goodsName;
	   public long goodsPrice;
	   public String goodImg;
	   public String goodType;
	   
	public Good(String goodsId, String goodsName,long goodsPrice,
			String goodImg, String goodType) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodImg = goodImg;
		this.goodType = goodType;
	}

	public Good(){
	}
	
	public String getGoodImg() {
	    return goodImg;
	  }
	   public void setGoodImg(String goodImg) {
	    this.goodImg = goodImg;
	   }

	    public String getGoodsId() {
	    return goodsId;
	}
	public void setGoodsId(String goodsId) {
	    this.goodsId = goodsId;
	}
	    public String getGoodsName() {
	    return goodsName;
	}
	public void setGoodsName(String goodsName) {
	    this.goodsName = goodsName;
	}
	public long getGoodsPrice() {
	    return goodsPrice;
	}
	public void setGoodsPrice(long goodsPrice) {
	    this.goodsPrice = goodsPrice;
	}
	public String getGoodType() {
		return goodType;
	}
	public Good(String goodsId) {
		this.goodsId = goodsId;
	}

	public void setGoodType(String goodType) {
		this.goodType = goodType;
	}

}
