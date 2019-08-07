package wsjava10;

import java.util.List;

public interface IBookMgr {
	void add(Book bk);
	List search();
	void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException;
	void buy(String isbn, int quantity) throws ISBNNotFoundException;
	int getTotalAmount();
	void open();
	void close();
	void send();
	
}
