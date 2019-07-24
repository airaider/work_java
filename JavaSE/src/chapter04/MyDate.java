package chapter04;

import java.util.Calendar;

public class MyDate {
	private int year, month, date;
	private Calendar today;
	{	//instance block : 객체 생성기 마다 수행되는 block으로 생성자보다 먼저 수행됨
		today = Calendar.getInstance();
	}
	public MyDate() {
		
		year = today.get(Calendar.YEAR);
		month = today.get(Calendar.MONTH)+1;
		date = today.get(Calendar.DATE);
	}
	public MyDate(int year, int month, int date) {
		setYear(year);
		setMonth(month);
		setDate(date);
	}
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if(year>=2018) {
			this.year = year;
		}
		else {
			System.err.println("2018년 이후 부터 설정하세요.");
			this.year = today.get(Calendar.YEAR);
		}
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if(month<1 || month>12) {
			System.err.println("1월 부터 12월 사이로 설정하세요.");
			this.month = today.get(Calendar.MONTH)+1;
		}
		else this.month = month;
		
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
//		1,3,5,7,8,10,12		31일까지
//		2	28일까지	year:4의배수 윤달, 100의배수 윤달X, 400의배수 윤달
//		4,6,9,11			30일까지
		if(date<1 || date>31) {
			System.err.println("1일 부터 31일 사이로 설정하세요.");
		}
		else {
			if(isValid(date)) {
				this.date=date;
				return;
			}
			else {
				System.err.printf("%d일은 %d월에 적합하지않은 날짜입니다.\n", date, month);
			}
		}
		this.date = today.get(Calendar.DATE);
//		switch (this.month) {
//		case 2:
//			if(this.year%4==0 && this.year%100!=0 && this.year%400==0) {
//				if(date<1 || date>29) {
//					System.err.println("1일 부터 29일 사이로 설정하세요.");
//					this.date = today.get(Calendar.DATE);
//				}
//			}
//			else this.date = date;
//			break;
//		case 1:
//		case 3:
//		case 5:
//		case 7:
//		case 8:
//		case 10:
//		case 12:
//			if(date<1 || date>31) {
//				System.err.println("1일 부터 31일 사이로 설정하세요.");
//				this.date = today.get(Calendar.DATE);
//			}
//			else this.date = date;
//			break;
//		case 4:
//		case 6:
//		case 9:
//		case 11:
//			if(date<1 || date>30) {
//				System.err.println("1일 부터 30일 사이로 설정하세요.");
//				this.date = today.get(Calendar.DATE);
//			}
//			else this.date = date;
//			break;
//		}
		

		
	}
	private boolean isValid(int date) {
		if((month == 2 && date>28)
		||(month==4)||(month==6)||(month==9)||(month==11) && date>30)
		return false;
		else return true;
	}
	public void setDate(int year, int month, int date) {
		setYear(year);
		setMonth(month);
		setDate(date);
	}
	public String toString() {
		return year+"년 "+month+"월 "+date+"일";
	}

}
