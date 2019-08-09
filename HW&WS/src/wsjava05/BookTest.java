package wsjava05;

public class BookTest {
	public static void main(String[] args) {
		BookManager manager = new BookManager();
		
		//입력기능
		manager.add(new Book("21424","Java Pro","김하나","Jaen.kr",15000,"Java 기본 문법"));
		manager.add(new Book("12345","Python Begin","홍기환","google.kr",18000,"python 기본 문법"));
		manager.add(new Book("88752","C++ Expert","이은규","ssafy.kr",10000,"c++ 심화"));
		manager.add(new Book("14833","C# Inter","이은규","ssafy.kr",10000,"c# 중급"));
		//출력기능
		manager.print();
		manager.add(new Magazine("35535","Java World","편집부","Java.com",2018,2,30000,"SW 모델링"));
		manager.add(new Magazine("42157","Chat Bot","국방부","python.com",2017,12,15000,"챗봇 모델링"));
		manager.add(new Magazine("35428","Git-Hub","교육부","github.com",2018,6,20000,"깃헙 활용"));
		manager.print();
		//isbn검색기능
		System.out.println("isbn검색");
		System.out.println(manager.search_isbn("21424"));
		//title검색기능
		System.out.println("title검색");
		System.out.println(manager.search_title("Java World"));
		//출판사검색기능
		System.out.println("출판사검색");
		System.out.println(manager.search_title("국방부"));
		//book검색
		System.out.println("책검색");
		manager.booksearch();
		//magazine검색
		System.out.println("잡지검색");
		manager.magazinesearch();
		//특정 가격 이하 출력
		System.out.println("특정가격이하(15000)");
		manager.search_price(15000);
		//가격 총합 및 평균
		System.out.println("총합 및 평균");
		System.out.println(manager.sum());
		System.out.println(manager.avg());
		

	}

}
