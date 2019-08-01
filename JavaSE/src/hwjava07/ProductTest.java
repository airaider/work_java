package hwjava07;

import java.util.List;

public class ProductTest {

	public static void main(String[] args) {
		ProductMgrImpl manager = new ProductMgrImpl();
		
		//입력기능
		manager.add(new TV("123","54인치",5400000,2,54,"ips"));
		manager.add(new TV("488","40인치",3200000,3,32,"led"));
		manager.add(new TV("159","27인치",3000000,1,30,"tn"));
		manager.add(new TV("486","50인치",7000000,4,70,"olled"));
		manager.add(new TV("751","32인치",4800000,6,48,"led"));
		manager.add(new TV("348","24인치",1600000,5,16,"lg"));
		manager.add(new Refrigerator("889","가정용",1000000,4,100));
		manager.add(new Refrigerator("839","업소용",1500000,2,400));
		manager.add(new Refrigerator("429","창고용",3000000,1,600));
		manager.add(new Refrigerator("989","회사용",2000000,3,300));
		manager.print();
		
		//번호검색기능
		System.out.println("number검색");
		System.out.println(manager.search_no("488"));
		//이름검색기능
		System.out.println("name검색");
		System.out.println(manager.search_name("가정용"));
		
		//TV검색
		System.out.println("tv검색");
		for(int i=0;i<manager.tvsearch().size();i++) {
			System.out.println(manager.tvsearch().get(i));
		}
		System.out.println("tv 50인치 검색");
		List<Product> tv50 = manager.tv50();
		for (Product product : tv50) {
			System.out.println(product);
		}
		//Refrigerator검색
		System.out.println("냉장고검색");
		for(int i=0;i<manager.refrigsearch().size();i++) {
			System.out.println(manager.refrigsearch().get(i));
		}
		System.out.println("냉장고 400 검색");
		for(int i=0;i<manager.refrig400().size();i++) {
			System.out.println(manager.refrig400().get(i));
		}
		//update
		System.out.println("update");
		System.out.println(manager.search_no("123"));
		System.out.println("54->60");
		manager.update("123", 6000000);
		System.out.println(manager.search_no("123"));
		//remove
		System.out.println("remove 123");
		manager.remove("123");
		manager.print();
		//가격 총합
		System.out.println("재고 금액 총합");
		System.out.println(manager.sum());
	}

}
