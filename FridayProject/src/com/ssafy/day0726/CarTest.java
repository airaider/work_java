package com.ssafy.day0726;

public class CarTest {

	public static void main(String[] args) {
		CarMgr m1 = CarMgr.getInstance();
		CarMgr m2 = CarMgr.getInstance();
		m1.add(new Car("123", "BMW", 100));
		m1.add(new Car("124", "BMW", 150));
		m1.add(new Car("126", "BMW", 120));
		m1.add(new Car("456", "Porsche", 200));
		m1.add(new Car("789", "Bentz", 180));
		m1.add(new Car("189", "Audi", 130));
		m1.add(new Car("195", "Audi", 140));
		m1.add(new Bus("1010", "고속버스", 80, 50));
		m1.add(new Bus("2004", "마을버스", 50, 30));
		m1.add(new Truck("4000", "티코", 10, 8));
		m1.search();
		System.out.println("차량번호검색");
		System.out.println(m1.search_num("123"));
		System.out.println("차량가격검색");
		m1.search_price(150);
		m1.update("189", 170);
		m1.remove("126");
		System.out.println("총 차량 대수");
		System.out.println(m1.size());
		System.out.println("총 차량 가격");
		System.out.println(m1.totalPrice());
		
	}

}
