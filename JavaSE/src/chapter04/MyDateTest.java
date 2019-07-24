package chapter04;

public class MyDateTest {

	public static void main(String[] args) {
		MyDate d1=new MyDate();
		System.out.println(d1.toString());
		MyDate d2=new MyDate(2017,13,32);
		System.out.println(d2.toString());
		d2.setDate(2019,7,17);
		System.out.println(d2.toString());
//		d1.year=2017;
//		d1.month=13;
//		d1.date=32;
		
		
//		toString() : 문자열에 객체를 연결할 때 자동호출되는 함수
//					 sysout으로 객체를 출력할 깨 호출되는 함수
	}

}
