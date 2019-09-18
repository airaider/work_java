package com.ssafy.product;

import java.io.Serializable;

public class Product implements Serializable{
	private String no;
	private String name;
	private String price2;
	private int price;
	private int stock;
	public Product() {
		
	}
	public Product(String no, String name, String price) {
		super();
		this.no = no;
		this.name = name;
		setPrice2(price);
	}
	public Product(String no, String name, int price, int stock) {
		super();
		this.no = no;
		this.name = name;
		setPrice(price);
		setStock(stock);
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
	public int getPrice() {
		return price;
	}
	public void setPrice2(String name) {
		this.price2 = name;
	}
	public String getPrice2() {
		return price2;
	}
	public void setPrice(int price) {
		if(price > 0) {
			this.price = price;
		}
		else {
			System.out.println("가격을 0원 이상으로 책정하세요.");
		}
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		if(stock > 0) {
			this.stock = stock;
		}
		else {
			System.out.println("수량을 0개 이상으로 책정하세요.");
		}
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [no=").append(no).append(", name=").append(name).append(", price=").append(price)
				.append(", stock=").append(stock).append("]");
		return builder.toString();
	}
	
	
}
