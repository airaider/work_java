package chapter04;

public class CustomerTest {

	public static void main(String[] args) {
		customer cust1;
//		local변수는 초기화를 하지 않고 연산을 하거나 매서드인자, 리턴 값으로 전달하면 컴파일 오류 발생
//		System.out.println(cust1);
		
		cust1 = new customer();
//		new에 의해서만 생성자 호출
//		초기화 작업 진행
		System.out.println(cust1);
//		속성은 객체가 생성될 때 기본값(정수:0 실수:0.0 문자:/u0000 논리:false 찹조형:null)값으로 초기화 됨.
		System.out.println(cust1.customerInfo());
		
		cust1.name="ssafy";
		cust1.age=2;
		cust1.address="서울시 강남구 역삼동";
		System.out.println(cust1.customerInfo());
		
//		.이 의미하는건 hashcode가 의미하는 함수로 가라!
//		hascode를 변수에 저장 (new)
		System.out.println(new customer().customerInfo());
		
		System.out.println(new customer("홍길동", 17, "율도국").customerInfo());
		
		customer cust2 = new customer("고길동", 40, "저리봐도");
		System.out.println(cust2.customerInfo());
		System.out.println(cust2.equals(cust1));	// cust2=this, cust1=cust
		
		

	}

}
