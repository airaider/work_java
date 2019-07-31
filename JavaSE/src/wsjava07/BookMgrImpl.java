package wsjava07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Calendar;

public class BookMgrImpl implements IBookMgr {

	private ArrayList<Book> books;
	public BookMgrImpl() {
		books = new ArrayList<Book>();
	}
	
	@Override
	public int findIndex(String isbn) {
		if(isbn != null) {
			for (int i = 0, size=books.size(); i < size; i++) {
				if(isbn.equals(books.get(i).getIsbn()))
					return i;
			}
		}
		return -1;
	}
	
	@Override
	public Book search(String isbn) {
		int index = findIndex(isbn);
		if(index>-1) {
			return books.get(index);
		}
		return null;
	}

	@Override
	public void add(Book bk) {
		
		if(books != null) {
			String isbn = bk.getIsbn();
			int index = findIndex(isbn);
			if(index > -1) {
				System.out.println("이미 등록된 책입니다.");
			}
			else {
				System.out.println("책을 저장합니다.");
				books.add(bk);
			}
		}
	}

	@Override
	public void update(Book bk) {
		if(bk != null) {
			String isbn = bk.getIsbn();
			int index = findIndex(isbn);
			if(index>-1) {
				books.set(index, bk);
			}else {
				System.out.println("수정할 책이 등록되지 않았습니다.");
			}
			
		}else {
			System.out.println("수정할 책의 정보를 입력해 주세요");
		}
	}

	@Override
	public void close() {
		System.exit(0);		
	}

	@Override
	public List<Book> searchAll() {
		return books;
	}

	@Override
	public Book search_title(String title) {
		int index = -1;
		if(title!=null) {
			for (int i = 0,size=books.size(); i < size; i++) {
				if(title.equals(books.get(i).getTitle()))
					index=i;
			}
		}
		if(index>-1) {
			return books.get(index);
		}
		else
		return null;
	}

	@Override
	public Book search_isbn(String title) {
		int index = -1;
		if(title!=null) {
			for (int i = 0,size=books.size(); i < size; i++) {
				if(title.equals(books.get(i).getIsbn()))
					index=i;
			}
		}
		if(index>-1) {
			return books.get(index);
		}
		else
		return null;
	}

	@Override
	public Book search_publisher(String title) {
		int index = -1;
		if(title!=null) {
			for (int i = 0,size=books.size(); i < size; i++) {
				if(title.equals(books.get(i).getPublisher()))
					index=i;
			}
		}
		if(index>-1) {
			return books.get(index);
		}
		else
		return null;
	}

	@Override
	public ArrayList<Book> search_price(int title) {
		ArrayList<Book> lt = new ArrayList<Book>();
		if(title > 0) {
			for (int i = 0,size=books.size(); i < size; i++) {
				if((title >= (books.get(i).getPrice()))){
					lt.add(books.get(i));
				}
			}
			return lt;
		}
		else
		return null;
	}

	@Override
	public ArrayList<Book> booksearch() {
		ArrayList<Book> lt = new ArrayList<Book>();
		for (int i = 0,size=books.size(); i < size; i++) {
			if(books.get(i) instanceof Book && !(books.get(i) instanceof Magazine)) {
				lt.add(books.get(i));
			}
			
		}
		return lt;
		
	}

	@Override
	public ArrayList<Book> magazinesearch() {
		ArrayList<Book> lt = new ArrayList<Book>();
		for (int i = 0,size=books.size(); i < size; i++) {
			if(books.get(i) instanceof Magazine) {
				lt.add(books.get(i));
			}
			
		}
		return lt;
		
	}

	@Override
	public int sum() {
		int sum=0;
		for (int i = 0,size=books.size(); i < size; i++) {
			sum+=books.get(i).getPrice();
		}
		return sum;
	}

	@Override
	public double avg() {
		double sum=0;
		for (int i = 0,size=books.size();i < size; i++) {
			sum+=books.get(i).getPrice();
		}
		return sum/(books.size());
	}

	@Override
	public ArrayList<Book> magazineyear() {
		ArrayList<Book> lt = new ArrayList<Book>();
		Calendar today = Calendar.getInstance();
		int time = today.get(Calendar.YEAR);
		for (int i = 0,size=books.size(); i < size; i++) {
			if(books.get(i) instanceof Magazine) {
				Magazine mr = (Magazine)books.get(i);
				if(mr.getYear()==time) {
					lt.add(mr);
				}
			}
			
		}
		return lt;
		
	}

	@Override
	public void print() {
		for (int i = 0,size=books.size(); i < size; i++) {
			System.out.println(books.get(i)); 
		}
		
	}

	
	

}
