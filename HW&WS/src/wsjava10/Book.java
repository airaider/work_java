package wsjava10;

import java.io.Serializable;

public class Book implements Serializable{
	private String isbn;
	private String title;
	private int price;
	private int quantity;
	
	public Book() {
		
	}
	
	public Book(String isbn, String title, int price, int quantity) {
		super();
		this.isbn = isbn;
		this.title = title;
		setPrice(price);
		setQuantity(quantity);
	}
	

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if(price>0) {
			this.price = price;
		}
		else {
			System.out.println("가격을 0원 이상으로 입력하세요.");
		}
		
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if(price>0) {
			this.quantity = quantity;
		}
		else {
			System.out.println("수량을 0개 이상으로 입력하세요.");
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [isbn=").append(isbn).append(", title=").append(title).append(", price=").append(price)
				.append(", quantity=").append(quantity).append("]");
		return builder.toString();
	}

	
}
