package wsjava07;

import java.util.ArrayList;
import java.util.List;



public interface IBookMgr {
	
	int findIndex(String isbn);
	Book search(String isbn);
	Book search_title(String title);
	Book search_isbn(String title);
	Book search_publisher(String title);
	ArrayList<Book> search_price(int title);
	void add(Book bk);
	void update(Book bk);
	void close();
	ArrayList<Book> booksearch();
	ArrayList<Book> magazinesearch();
	ArrayList<Book> magazineyear();
	int sum();
	double avg();
	void print();
	List<Book> searchAll();
}
