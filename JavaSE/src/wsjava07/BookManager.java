package wsjava07;

import java.util.Arrays;

public class BookManager {
	private Book[] books;
	private int bookindex;
	
	public BookManager() {
		books = new Book[15];
	}
	
	
	public Book search_title(String title) {
		int index = -1;
		if(title != null) {
			for (int i = 0; i < bookindex; i++) {
				if(title.contains(books[i].getTitle()))
					index=i;
			}
		}
		if(index>-1) {
			return books[index];
		}
		else
			return null;
		
		
	}
	public Book search_isbn(String title) {
		int index = -1;
		if(title != null) {
			for (int i = 0; i < bookindex; i++) {
				if(title.contains(books[i].getIsbn()))
					index=i;
			}
		}
		if(index>-1) {
			return books[index];
		}
		else
			return null;
	}
	public Book search_publisher(String title) {
		int index = -1;
		if(title != null) {
			for (int i = 0; i < bookindex; i++) {
				if(title.contains(books[i].getPublisher()))
					index=i;
			}
		}
		if(index>-1) {
			return books[index];
		}
		else
			return null;
	}
	
	public Book search_price(int title) {
		int index = -1;
		if(title > 0) {
			for (int i = 0; i < bookindex; i++) {
				if(title >= (books[i].getPrice())) {
					System.out.println(books[i]);
				}
			}
		}
		if(index>-1) {
			return books[index];
		}
		else
			return null;
	}
	
	public int findIndex(String empno) {
		if(empno != null) {
			for (int i = 0; i < bookindex; i++) {
				if(empno.equals(books[i].getIsbn()))
				return i;
			}
		}
		return -1;
	}
	
	public void booksearch() {
		for (int i = 0; i < bookindex; i++) {
			if(books[i] instanceof Book && !(books[i] instanceof Magazine)) {
				System.out.println(books[i]);
			}
			
		}
	}
	public void magazinesearch() {
		for (int i = 0; i < bookindex; i++) {
			if(books[i] instanceof Magazine) {
				System.out.println(books[i]);
			}
			
		}
	}
	
	public void add(Book book) {
		System.out.println("book을 저장합니다.");
		if(book != null) {
			String isbn = book.getIsbn();
			int index = findIndex(isbn);
			if(index > -1) {
				System.out.println("이미 등록된 등록번호입니다.");
			}else {
				if(bookindex >= books.length) {
					books = Arrays.copyOf(books, bookindex+5);
				}
				books[bookindex++] = book;
			}
		}
	}
	public void print() {
		for (int i = 0; i < bookindex; i++) {
			System.out.println(books[i]); 		//virtual invoke **시험 문제**
		}
	}
	public int sum() {
		int sum=0;
		for (int i = 0; i < bookindex; i++) {
			sum+=books[i].getPrice();
		}
		return sum;
	}
	public double avg() {
		double sum=0;
		for (int i = 0; i < bookindex; i++) {
			sum+=books[i].getPrice();
		}
		return sum/(bookindex);
	}
	
}
