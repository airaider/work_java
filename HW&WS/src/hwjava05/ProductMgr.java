package hwjava05;

import java.util.Arrays;


public class ProductMgr {
	private Product[] products;
	private int pindex;
	
	public ProductMgr() {
		products = new Product[10];
	}
	public Product search_no(String title) {
		int index = -1;
		if(title != null) {
			for (int i = 0; i < pindex; i++) {
				if(title.contains(products[i].getNo()))
					index=i;
			}
		}
		if(index>-1) {
			return products[index];
		}
		else
			return null;
	}
	public Product search_name(String title) {
		int index = -1;
		if(title != null) {
			for (int i = 0; i < pindex; i++) {
				if(title.contains(products[i].getName()))
					index=i;
			}
		}
		if(index>-1) {
			return products[index];
		}
		else
			return null;
	}
	
	
	public void add(Product pro) {
		System.out.println("Product을 저장합니다.");
		if(pro != null) {
			String no = pro.getNo();
			int index = findIndex(no);
			if(index > -1) {
				System.out.println("이미 등록된 제품번호입니다.");
			}else {
				if(pindex >= products.length) {
					products = Arrays.copyOf(products, pindex+5);
				}
				products[pindex++] = pro;
			}
		}
	}
	public int findIndex(String empno) {
		if(empno != null) {
			for (int i = 0; i < pindex; i++) {
				if(empno.equals(products[i].getNo()))
				return i;
			}
		}
		return -1;
	}
	public void tvsearch() {
		for (int i = 0; i < pindex; i++) {
			if(products[i] instanceof TV) {
				System.out.println(products[i]);
			}
			
		}
	}
	public void refrigeratorsearch() {
		for (int i = 0; i < pindex; i++) {
			if(products[i] instanceof Refrigerator) {
				System.out.println(products[i]);
			}
			
		}
	}
	public int sum() {
		int sum=0;
		for (int i = 0; i < pindex; i++) {
			for(int j=0;j<products[i].getStock();j++)
				sum+=products[i].getPrice();
		}
		return sum;
	}
	
	public void print() {
		for (int i = 0; i < pindex; i++) {
			System.out.println(products[i]); 		//virtual invoke **시험 문제**
		}
	}
}
