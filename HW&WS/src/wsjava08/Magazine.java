package wsjava08;

import java.util.Calendar;

public class Magazine extends Book {
	private int month;
	public Magazine() {
		
	}
	public Magazine(String isbn, String title, int price, int quantity, int month) {
		super(isbn, title, price, quantity);
		setMonth(month);
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		if(month>=1 && month<=12) {
			this.month = month;
		}
		else {
			Calendar today = Calendar.getInstance();
			this.month = today.get(Calendar.MONTH)+1;
			System.out.println("1월과 12월 사이의 달을 입력하세요.");
		}
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Magazine [month=").append(month).append("]");
		return builder.toString()+super.toString();
	}
	
}
