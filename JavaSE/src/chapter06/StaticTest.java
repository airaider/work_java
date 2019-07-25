package chapter06;

/**
 * static : 정적인 특성 부여
 *  - 클래스가 로딩되는 시점에 결정됨
 *  - 객체 생성없이 클래스로만 접근 가능
 *    Class.속성명, Class.매서드명(~)
 *    
 * 	속성 :	클래스가 로딩될 때 메모리에 한번 할당됨
 *  		공유 변수가 됨
 * 	매서드 :	클래스가 로딩될 때 매서드 바인딩을 한다(정적 바인딩)
 *  		jvm에서 가장 힘든게 class 생성이다(& garbage collecting)
 *  		-유틸리티성 매서드
 * 			(속성이나, non-static method를 사용하지 않고 전달된 인자로만 처리하는 기능)
 * 		     
 * 	static block : 클래스가 로딩될 때 한번 수행
 * 			-static 속성을 초기화 하거나 단 한번 수행될 코드를 작성
 * 	instance block : 객체가 생성될 때마다 수행되고, 생성자 보다 먼저 수행됨
 * 			-어떤 생성자로 객체를 생성하던 공통적으로 수행될 코드가 있다면 instance block에서 작성
 */
class Counter{
	static int scount;	//객체들이 공유 되는 공유 변수
	int icount;			//객체가 생성될 때마다 heap에 메모리 할당이 됨
	Counter(){
		scount++;
		icount++;
	}
	public void print() {
		System.out.println("scount:"+scount);
		System.out.println("icount:"+icount);
	}
	/** static 매서드에서는 static 속성이나 static 매서드에만 접근 가능*/
	public static void sprint() {
		System.out.println("scount:"+scount);
//		System.out.println("icount:"+icount);
	}
	
}

public class StaticTest {
	public static void main(String[] args) {
		System.out.println(Counter.scount);
		Counter.sprint();
		Counter c1 = new Counter();
		Counter c2 = new Counter();
		Counter c3 = new Counter();
		c1.print();
		c2.print();
		c3.print();
	}
}
