package chapter05;

public class PolymorphismTest {

	public static void main(String[] args) {
		/** Reference Polymorphism
		 * 	- Super타빙ㅂ의 변수로 Sub타입의 객체를 참조할 수 있다.
		 */
		Employee emp1 = new Employee();
		emp1 = new Manager();			//다형성
		emp1 = new Engineer();			//다형성
		
//		Engineer eng1 = new Employee();	//다형성 아님
//		Engineer eng1 = new Manager();	//다형성 아님
		
//		다형성 관계에서 sub에 추가된 속성이나 매서드에 접근 불가
//		System.out.println(emp1.getSkill());	//shadow impact
		
		/**
		 * Reference type 형변환
		 * 자동 형변환	(Up casting)	: sub type에서 super type으로 형변환될 때 자동 형변환 됨
		 * => 모든 sub는 super으로 자동 형변환됨
		 * 명시적 형변환 (Down casting)	: super type에서 sub type으로 형변활될 때 명시적 형변환
		 * => super type에서 sub type으로 형변환될 때 명시적으로 형변환 해야 한다
		 * => super type이 참조하고 있는 객체의 sub타입으로만 형변환 됨
		 */
		Manager mgr2 = new Manager();
		Employee emp2 = mgr2;				//up casting
		
		Engineer eng2 = new Engineer();
		emp2 = eng2;						//up casting
		
		Engineer eng3 = (Engineer) emp2;				//down casting error
//		Manager mgr3 = (Manager) emp2;					//error 다른 subclass로 casting 불가능(ClassCastExecption)
		
		/**
		 * instanceof : Reference 타입의 형검사
		 * - 객체가 해당 클래스 타입이면 true, 아니면 false
		 * 형식]
		 * 		객체	instanceof 클래스타입
		 * 
		 * 주의점 : super타입부터 검사하면 모든 sub는 super타입으로 검사된다
		 * 형검사는 super타입보단 sub타입을 우선적으로 검사를 한다
		 */
		
		if (emp2 instanceof Manager) {
			Manager mgr = (Manager) emp2;
			System.out.println("emp2는 Manager입니다. 직위 :"+mgr.getPosition());
		}else if(emp2 instanceof Engineer) {
			Engineer eng = (Engineer) emp2;
			System.out.println("emp2는 Engineer입니다. 보유기술 :"+eng.getSkill());
		}
		System.out.println(emp2.toString());
		
		/**Virtual Invocation(Dynamic Binding == Dynamic linking)
		 * 다형성 관계에서 매서드가 override된 경우라면 override 된 함수가 호출괸
		 * 
		 */
		
	}
	

}
