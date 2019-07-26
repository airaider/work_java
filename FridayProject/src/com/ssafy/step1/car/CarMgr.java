package com.ssafy.step1.car;

import java.util.Arrays;

public class CarMgr{
	private Car[] cars = new Car[10];
	private int cindex;
	//2. 객체를 1번 생성해서 참조변수에 저장한다(참조변수는  static으로 작성)
	private static CarMgr instance = new CarMgr();
	
	//1. 생성자를 private
	private CarMgr() {
		super();
	}
	//3. 참조변수가 private일 경우 getter제공
	public static CarMgr getInstance() {
		return instance;
	}
	public int findIndex(String num) {
		if(num != null) {
			for (int i=0;i<cindex;i++) {
				if(num.equals(cars[i].getNum()))
					return i;
			}
		}
		return -1;
	}
	public void search() {
		for(int i =0;i<cindex;i++) {
			System.out.println(cars[i]);
		}
	}
	public Car search_num(String num) {
		int index = -1;
		if(num != null) {
			for(int i =0;i<cindex;i++) {
				if(num.contains(cars[i].getNum())) {
					index=i;
				}
			}
		}
		if(index>-1) {
			return cars[index];
		}
		else	
			return null;
	}
	public void search_price(int title) {
		if(title > 0) {
			int in=0;
			for (int i = 0; i < cindex; i++) {
				if(title >= (cars[i].getPrice())) {
					System.out.println(cars[i]);
					in++;
				}
			}
			if(in==0) {
				System.out.println(title+"가격 이하의 차량이 없습니다.");
			}
			return;
		}
		else {
			System.out.println("0원 이상의 가격을 입력하세요");
			return;
		}
		
	}
	
	public void add(Car vehicle) {
		System.out.println("차량을 저장합니다.");
		if(vehicle != null) {
			String num = vehicle.getNum();
			int index = findIndex(num);
			if(index > -1) {
				System.out.println("이미 등록된 차량입니다.");
			}else {
				if(cindex >= cars.length) {
					cars = Arrays.copyOf(cars, cindex+10);
				}
				cars[cindex++] = vehicle;
			}
		
		}
	}
	public void remove(String name) {
		int index = findIndex(name);
		if(index > -1) {
			cars[index]=cars[--cindex];
			System.out.println('"'+name+'"'+"차량을 삭제했습니다");
		}
		else {
			System.out.println("삭제할 차량이 등록되지 않았습니다.");
		}
	}
	public void update(String num, int price) {
		int index = -1;
		if(num != null) {
			for(int i =0;i<cindex;i++) {
				if(num.contains(cars[i].getNum())) {
					index=i;
				}
			}
		}
		if(index>-1) {
			System.out.println("가격을 수정했습니다");
			cars[index].setPrice(price);
			System.out.println(cars[index]);
		}
		else
			System.out.println("등록된 차량이 없습니다");;
	}
	public int size() {
		return cindex;
	}
	public int totalPrice() {
		int sum=0;
		for (int i = 0; i < cindex; i++) {
			sum+=cars[i].getPrice();
		}
		return sum;
	}
	
	
	
}
