package com.ssafy.product.dto;

import java.io.Serializable;

public class Product implements Serializable{
	private String no;
	private String name;
	private String price;
	private String descrip;
	public Product() {}
	public Product(String no, String name, String price, String descrip) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.descrip = descrip;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [no=").append(no).append(", name=").append(name).append(", price=").append(price)
				.append(", descrip=").append(descrip).append("]");
		return builder.toString();
	}
	

}
