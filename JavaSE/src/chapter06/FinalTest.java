package chapter06;
/**
 * final : 값 변경 불가
 * 클래스  : 상속 금지		ex) String, System
 * 매서드 : override 금지
 * 변수(속성, 로컬변수) : 값 변경 불가
 */

//class SubString extends String{}	final 클래스를 상속 받으면 컴파일 에러 발생

class Super1{
	public final void test() {
		
	}
}

class Sub1 extends Super1{
//	public final void test() {}	final method는 override 금지
}

/*
 * Blank Final Variable
 * - final 속성을 선언시에 값을 할당하지 않고 객체 생성시에 값을 할당해서 사용
 * - 객체 마다 다른 고정값 사용
 * - 모든 생성자에서 Blank Final Variable을 한번 초기화 해야 한다.
 */
class Blank{
	private final int serialNo;
	static int count;
	public Blank() {
		serialNo = ++count;
	}
	public Blank(int sno) {
		serialNo = sno;
	}
	public int getSerialNo() {
		return serialNo;
	}
//	public void setSerialNo(int sno) {
//		serialNo = sno;
//	}
	
	
}

public class FinalTest {

	public static void main(String[] args) {
		final double PI = 3.14;
//		PI = 3.141592;	final로 선언된 변수는 값 변경 불가
	}

}
