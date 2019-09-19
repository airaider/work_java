package com.ssafy.product.dto;

import java.io.Serializable;

public class Product implements Serializable{
	private String no;
	private String name;
	private String price;
	private String explain;
	public Product() {}
	public Product(String no, String name, String price, String explain) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.explain = explain;
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
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [no=").append(no).append(", name=").append(name).append(", price=").append(price)
				.append(", explain=").append(explain).append("]");
		return builder.toString();
	}
	

}
