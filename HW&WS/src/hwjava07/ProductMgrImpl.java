package hwjava07;

import java.util.ArrayList;


public class ProductMgrImpl implements IProductMgr {

	private ArrayList<Product> products;
	public ProductMgrImpl() {
		products = new  ArrayList<Product>();
	}
	public int findIndex(String isbn) {
		if(isbn != null) {
			for (int i = 0, size=products.size(); i < size; i++) {
				if(isbn.equals(products.get(i).getNo()))
					return i;
			}
		}
		return -1;
	}
	
	public void add(Product pro) {

		if(products != null) {
			String isbn = pro.getNo();
			int index = findIndex(isbn);
			if(index > -1) {
				System.out.println("이미 등록된 제품입니다.");
			}
			else {
				System.out.println("제품을 저장합니다.");
				products.add(pro);
			}
		}
		
	}

	@Override
	public Product search_no(String title) {
		int index = -1;
		if(title!=null) {
			for (int i = 0,size=products.size(); i < size; i++) {
				if(title.equals(products.get(i).getNo()))
					index=i;
			}
		}
		if(index>-1) {
			return products.get(index);
		}
		else
		return null;
	}

	@Override
	public Product search_name(String title) {
		int index = -1;
		if(title!=null) {
			for (int i = 0,size=products.size(); i < size; i++) {
				if(title.equals(products.get(i).getName()))
					index=i;
			}
		}
		if(index>-1) {
			return products.get(index);
		}
		else
		return null;
	}

	@Override
	public ArrayList<Product> tvsearch() {
		ArrayList<Product> lt = new ArrayList<Product>();
		for (int i = 0,size=products.size(); i < size; i++) {
			if(products.get(i) instanceof TV) {
				lt.add(products.get(i));
			}
			
		}
		return lt;
	}

	@Override
	public ArrayList<Product> tv50() {
		ArrayList<Product> lt = new ArrayList<Product>();
		for (int i = 0,size=products.size(); i < size; i++) {
			if(products.get(i) instanceof TV && ((TV)products.get(i)).getInch()>=50) {
				lt.add(products.get(i));
			}
			
		}
		return lt;
	}

	@Override
	public ArrayList<Product> refrigsearch() {
		ArrayList<Product> lt = new ArrayList<Product>();
		for (int i = 0,size=products.size(); i < size; i++) {
			if(products.get(i) instanceof Refrigerator) {
				lt.add(products.get(i));
			}
			
		}
		return lt;
	}

	@Override
	public ArrayList<Product> refrig400() {
		ArrayList<Product> lt = new ArrayList<Product>();
		for (int i = 0,size=products.size(); i < size; i++) {
			if(products.get(i) instanceof Refrigerator && ((Refrigerator)products.get(i)).getCapacity()>=400) {
				lt.add(products.get(i));
			}
			
		}
		return lt;
	}

	@Override
	public void update(String no, int price) {
		int index = -1;
		if(no!=null) {
			for (int i = 0,size=products.size(); i < size; i++) {
				if(no.equals(products.get(i).getNo()))
					index=i;
			}
		}
		if(index>-1) {
			products.get(index).setPrice(price);
		}
		else
		return;
		
		
	}

	@Override
	public void remove(String no) {
		int index = -1;
		if(no!=null) {
			for (int i = 0,size=products.size(); i < size; i++) {
				if(no.equals(products.get(i).getNo()))
					index=i;
			}
		}
		if(index>-1) {
			products.remove(index);
		}
		else
		return;
	}

	@Override
	public int sum() {
		int sum=0;
		for (int i = 0,size=products.size(); i < size; i++) {
			for(int j=0;j<products.get(i).getStock();j++)
				sum+=products.get(i).getPrice();
		}
		return sum;
	}
	@Override
	public void print() {
		for (int i = 0,size=products.size(); i < size; i++) {
			System.out.println(products.get(i).toString()); 
		}
		
	}

}
