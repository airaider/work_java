package chapter06;

import java.io.Serializable;

import chapter06.sub.Trans;

/**
 * interface
 * - 상수와 추상 메소드로만 구성되어 있다.
 * 	> 속성에 자동으로 public static final이 컴파일때 추가된다
 * 	> 메서드에 자동으로 public abstract이 컴파일때 추가된다
 * - 객체를 생성할 수 없지만 다형성에 의해 sub는 참조 가능
 * - 다중 상속이 가능  => 다형성
 * - 선언]
 * 		[public] interface 인터페이스명 [extends 슈퍼인터페이스명1, ...]{}
 * - 구현]
 * 		[modifiers] class 클래스명 [extends 슈퍼클래스명]
 * 								[implements 슈퍼인터페이스명1, ...]{}
 *
 */
interface Flyer extends Trans, Cloneable{
	void fly();
}

class Human{
	public void start() {
		System.out.println("걸어 갑니다");
	}
}

class SuperMan extends Human implements Flyer, Serializable{
	public void fly() {
		System.out.println("하늘을 날아서 지구를 구하장!!");
	}
	public void stop() {
		System.out.println("잠깐 쉬어야징!!");
	}
}

public class InterfaceTest {
	public static void main(String[] args) {
//		package가 다른데 접근 가능, 객체 생성없이 접근 가능 => public static이다
		System.out.println(Trans.INIT);
//		Trans.INIT=20;	final인것을 확인
		SuperMan clark = new SuperMan();
		Trans t = clark;
		Flyer f = clark;
		Human h = clark;
		Cloneable c = clark;
	}

}
