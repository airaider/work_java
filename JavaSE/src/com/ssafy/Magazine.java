package com.ssafy;

import java.util.Calendar;

public class Magazine {
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private int year;
	private int month;
	private int price;
	private String desc;
	
	public Magazine() {
		
	}
	
	public Magazine(String isbn, String title, String author, String publisher, int year, int month, int price,
			String desc) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		setYear(year);
		setMonth(month);
		setPrice(price);
		this.desc = desc;
		
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if(price>=0) this.price = price;
		else System.out.println("책 가격은 0원 이상으로 설정하세요");
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String toString() {
		return isbn+"\t|"+title+"\t|"+author+"\t|"+publisher+"\t|"+price+"\t|"+desc+"\t|"+year+"."+month;
	}
}
