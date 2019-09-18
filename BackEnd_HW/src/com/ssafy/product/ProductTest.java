package com.ssafy.product;

import java.util.ArrayList;

public class ProductTest {

	public static void main(String[] args) throws DuplicateException, CodeNotFound, ProductNotFound {
		ProductMgrImpl manager = ProductMgrImpl.getInstance();
		try {
			manager.add(new Refrigerator("839","업소용",1500000,2,400));
			manager.add(new Refrigerator("429","창고용",3000000,1,600));
			manager.add(new TV("123","54인치",5400000,2,54));
			manager.add(new TV("488","40인치",3200000,3,32));
			manager.add(new TV("159","27인치",3000000,1,30));
			manager.add(new Refrigerator("889","가정용",1000000,4,100));
			manager.add(new TV("486","50인치",7000000,4,70));
			manager.add(new TV("751","32인치",4800000,6,48));
			manager.add(new TV("348","24인치",1600000,5,16));
			manager.add(new Refrigerator("989","회사용",2000000,3,300));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		ArrayList<Product> al = new ArrayList<Product>();
		System.out.println("전체 출력");
		al = manager.search();
		for (Product product : al) {
			System.out.println(product);
		}
		System.out.println("488");
		System.out.println(manager.search_no("488"));
		System.out.println("400L");
		al = new ArrayList<Product>();
		al = manager.search_400L();
		for (Product product : al) {
			System.out.println(product);
		}
		System.out.println("50inch");
		al = new ArrayList<Product>();
		al = manager.search_50inch();
		for (Product product : al) {
			System.out.println(product);
		}
		
		manager.close();
		manager.send();
	}

}
