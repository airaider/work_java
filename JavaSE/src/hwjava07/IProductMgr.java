package hwjava07;

import java.util.ArrayList;


public interface IProductMgr {
	int findIndex(String isbn);
	void add(Product pro);
	Product search_no(String title);
	Product search_name(String title);
	ArrayList<Product> tvsearch();
	ArrayList<Product> tv50();
	ArrayList<Product> refrigsearch();
	ArrayList<Product> refrig400();
	void update(String no, int price);
	void remove(String no);
	int sum();
	void print();
	
}
