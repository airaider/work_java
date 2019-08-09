package hwjava10;

import java.util.ArrayList;

public interface IProductMgr {
	void add(Product pro) throws DuplicateException;
	ArrayList search();
	Product search_no(String no) throws CodeNotFound;
	ArrayList search_400L() throws ProductNotFound;
	ArrayList search_50inch() throws ProductNotFound;
	void open();
	void save();
	void close();
	void send();
}
