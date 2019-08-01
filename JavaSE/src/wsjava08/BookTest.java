package wsjava08;

import java.util.List;

public class BookTest {
	public static void main(String[] args) throws QuantityException, ISBNNotFoundException {
		BookMgrImpl manager = new BookMgrImpl();
		
		//책 입력
		manager.add(new Book("21424","Java Pro",15000,1));
		manager.add(new Book("12345","Python Begin",18000,2));
		manager.add(new Book("88752","C++ Expert",10000,3));
		manager.add(new Book("14833","C# Inter",10000,2));
		//잡지 입력
		manager.add(new Magazine("35535","Java World",30000,2,12));
		manager.add(new Magazine("42157","Chat Bot",15000,4,11));
		manager.add(new Magazine("35428","Git-Hub",20000,6,7));
		//전체 출력
		List<Book> books = manager.search();
		for (Book book : books) {
			System.out.println(book);
		}
		manager.search();
		//책 판매 기능
		System.out.println("책 판매");
		manager.sell("12345", 1);
		//책 구매 기능
		System.out.println("책 구매");
		manager.buy("14833", 4);
		//책 가격 총합
		System.out.println(manager.getTotalAmount());
		
		
		books = manager.search();
		for (Book book : books) {
			System.out.println(book);
		}
		manager.close();

	}

}
