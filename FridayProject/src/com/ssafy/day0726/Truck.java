package com.ssafy.day0726;

public class Truck extends Car {
	private int ton;


	public Truck() {
	}

	public Truck(String num, String model, int price, int ton) {
		super(num, model, price);
		setTon(ton);
	}

	public int getTon() {
		return ton;
	}

	public void setTon(int ton) {
		if(ton>0)
			this.ton = ton;
		else
			System.out.println("톤은 0t 이상으로 설정하세요.");
	}
	public String toString() {
		return super.toString()+" ton=" + ton+"|";
	}
	
}
