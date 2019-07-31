package chapter06;

import java.util.Calendar;

/**
 *	추상 : 추상적인 특징 부여
 *	- 메서드 :
 *		> 메서드를 선언부만 작성하고 구현을 하지 않는다
 *		> sub에서 추상메소드를 구현하도록 강제윙ㅁ
 *		> sub에서 추상 메소드를 override하지 않으면 컴파일 에러 발생
 *		> 형식
 *		[access modifier] abstract 리턴타입 메서드명([인자들,...])
 *		>static, final 같이 사용 불가 
 *	- 목적
 *	1. sub들이 세부 구현이 너무 달라서 공통 코드가 없는 경우
 *	2. 변경을 예상할 수 없는 경우
 *	- 효과
 *	1. 가볍게 상속
 *	2. override에 대한 성능 저하를 ㅈ금 줄일 수 있다
 *	3. 설계시에 sub에서 반드시 override 하도록 제어
 *
 *	- 클래스 :
 *		> 객체 생성 불가
 *		> 상속 전용, 다형성 전용
 *		> 클래스 내에 추상 메서드가 있으면 반드시 추상 클래스로 선언해야 한다
 * 
 *
 */
abstract class Animal{
	private String name;
	private String kind;
	private int age;
	public Animal() {}
	/**추상 클래스라도 sub클래스에서 호출될 수 있으므로 필요하다면 생성자를 선언한다*/
	public Animal(String name, String kind, int age) {
		this.name = name;
		this.kind = kind;
		this.age = age;
	}
	public abstract void bark();
	public abstract void special();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}

class Dog extends Animal{
	public void bark() {
		System.out.println("멍멍");
	}
	public void special() {
		keep();
	}
	public void keep() {
		Calendar today = Calendar.getInstance();
		int time = today.get(Calendar.HOUR_OF_DAY);
		if(time >= 9 && time <=18) {
			System.out.println("잘 지키고 있어요");
		}
		else {
			System.out.println("나도 좀 쉽시다~~~");
		}
	}
}

class Duck extends Animal{
	public Duck() {}
	public Duck(String name, String kind, int age) {
		super(name, kind, age);
	}
	public void special() {
		fly();
	}
	public void bark() {
		System.out.println("꽥꽥");
	}
	public void fly() {
		String kind = getKind();
		if(kind != null && kind.equals("집오리")) {
			System.out.println("오리는 날수 없다 엄매에게 혼났죠~");
		}
		else {
			System.out.println("날아올라 저 하늘 날고 있어여. 이렇게 멋진 날개를 펴~~");
		}
	}
}

public class AbstractTest {

	public static void main(String[] args) {
//		Animal an = new Animal(); 추상 클래스는 자기 자신으로 클래스 선언 불가
		/** 추상 클래스라도 다형성을 적용하여 sub 객체를 찹조 할 수 있다.*/
		Animal ani = new Dog();
		ani.bark();
		/** 추상 클래스라도 배열 객체는 생성할 수 있다*/
		Animal[] animals = new Animal[2]; /*sub들을 저장할 수 있다*/
		animals[0] = new Dog();
		animals[1] = new Duck("채리필터", "오리날다", 20);
		for(Animal animal : animals) {
			animal.bark();
			animal.special();
//			if(animal instanceof Dog) {
//				Dog dog = (Dog) animal;
//				dog.keep();
//			}
//			else if(animal instanceof Duck) {
//				Duck duck = (Duck) animal;
//				duck.fly();
//			}
			
			
		}
		
	}

}
