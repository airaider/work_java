package com.ssafy.step1.car;

public class Bus extends Car {
	private int seat;

	public Bus() {
	}

	public Bus(String num, String model, int price, int seat) {
		super(num, model, price);
		setSeat(seat);
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		if(seat>0)
			this.seat = seat;
		else
			System.out.println("좌석을 0석 이상으로 입력하세요.");
	}

	@Override
	public String toString() {
		return super.toString()+" seat=" + seat+"|";
	}

	

}
