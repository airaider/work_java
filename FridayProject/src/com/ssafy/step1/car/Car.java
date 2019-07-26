package com.ssafy.step1.car;

public class Car {
	private String num;
	private String model;
	private int price;
	public Car() {}
	public Car(String num, String model, int price) {
		this.num = num;
		this.model = model;
		setPrice(price);
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price>0) this.price = price;
		else System.out.println("가격을 0원 이상으로 설정하세요.");
	}
	@Override
	public String toString() {
		return model+" |num=" + num + "| model=" + model + "| price=" + price + "|";
	}
	
}
