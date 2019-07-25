package chapter05;

public class MainCustomer extends customer {
	private String hobby;
	public MainCustomer() {
		
	}
	public MainCustomer(String name, int age, String address, String hobby) {
//		this.name=name;			/**상속 받은 속성*/
//		this.age=age;			/**상속 받은 속성*/
//		this.address=address;	/**상속 받은 속성*/
//		this.hobby=hobby;		
//		setName(name);
//		setAge(age);
		/**생성자는 상속되지 않지만 재사용을 위해 호출 가능
		 * super(~)
		 * 주의점 : 생성자의 첫번째 명령에서만 호출 가능
		 *  */
		super(name,age,address);
		this.hobby=hobby;
	}
	/**
	 * Method Override(함수 재정의)
	 * - 상속 박은 매서드와 동일한 이름의 함수를 선언할 수 있다.
	 * - 목적
	 *   상속 받은 매서드와 기능이 동일하지만 상세 구현이 조금 다른 경우
	 *   반영하기 위해 새로운 매서드를 작성해야하는데 이때 매서드 이름과, 인자, 리턴타입을
	 *   상속 받은 매서드와 동일하게 선언한다.
	 *   
	 * - 효과
	 *	1. 상속 받은 새거드와 이름, 인자가 같으므로 매서드 호출하는 방법이 같고
	 *	       리턴 타입이 같으므로 호출후 처리 방법이 같아지므로 기존 코드를 변경하지 않고
	 * 	       수정된 내용을 반영할 수 있다.
	 *	2. 기능이 동일한 경우 부모 객체, 자식 객체 구별하지 않고 같은 이름으로 함수를 호출한다.
	 *	   => 호출에 대한 편리성
	 *  3. 다형성 관계에서는 Override된 매서드가 호출됨(Virtual Invocation)
	 *	       기존 코드를 변경하지 않고 수정된 내용을 반영할 수 있다
	 *  4. shadow impact를 해결할 수 있다 
	 *   
	 * - 규칙
	 * 	1. 매서드 이름과 인자는 반드시 같아야 한다.
	 * 	2. 리턴 타입
	 * 		1.7 리턴 타입이 반드시 같아야 한다
	 * 		1.8 같은 타입이거나 sub를 리턴해야 됨
	 * 		ex) 부모 : public Customer getCustomer(){}
	 * 			자식 : public Customer getCustomer(){}
	 * 			or	 public MainCustomer getCustomer(){}	
	 *  3. access modifier는 같거나 보다 넓은 범위 (public)로 선언한다
	 *  	=> access modifier를 줄이면 컴파일 오류 발생
	 *  4. 예외는 같은 예외를 던지거나 sub를 던지거나 안던져도 됨
	 *  	=> super를 던지면 컴파일 오류 발생
	 */
	
	
	public String customerInfo(){
//		return "이름:"+name+" 나이:"+age+" 주소:"+address+" 취미:"+hobby;
		/*
		 * super
		 * 재정의에 의해 무시된 부모의 멤버(속성,함수)에 접근할 때 super를 상ㅇ
		 * super.함수명(~)	super.속성명
		 */
		return super.customerInfo()+" 취미:"+hobby;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
}
