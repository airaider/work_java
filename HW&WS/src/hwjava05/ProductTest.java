package hwjava05;


public class ProductTest {

	public static void main(String[] args) {
		ProductMgr manager = new ProductMgr();
		
		//입력기능
		manager.add(new TV("123","54인치",5400000,2,54,"ips"));
		manager.add(new TV("488","40인치",3200000,3,40,"led"));
		manager.add(new Refrigerator("889","가정용",1000000,1,30));
		manager.print();
		
		//번호검색기능
		System.out.println("number검색");
		System.out.println(manager.search_no("488"));
		//이름검색기능
		System.out.println("name검색");
		System.out.println(manager.search_name("가정용"));
		
		//TV검색
		System.out.println("tv검색");
		manager.tvsearch();
		//Refrigerator검색
		System.out.println("냉장고검색");
		manager.refrigeratorsearch();
		
		//가격 총합
		System.out.println("재고 금액 총합");
		System.out.println(manager.sum());
	}

}
