package wsjava07;

import java.util.Calendar;

public class Magazine extends Book {
	private int year;
	private int month;
	public Magazine() {
		
	}
	public Magazine(String isbn, String title, String author, String publisher, int year, int month, int price,
			String desc) {
		super(isbn, title, author, publisher, price, desc);
		this.year = year;
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		if(1>month || month>12) {
			System.out.println("달은 1월부터 12월 사이로 설정하세요");
			Calendar today = Calendar.getInstance();
			this.month = today.get(Calendar.MONTH)+1;
		}
		else this.month=month;
	}
	public String toString() {
		return super.toString()+"\t|"+year+"."+month;
	}
	
}
