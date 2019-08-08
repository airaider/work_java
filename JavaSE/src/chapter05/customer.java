package chapter05;

public class customer {
	private String name;
	private int age;
	private String address;
	/*
	 * 생성자
	 * - 객체 생성시 new에 의해 호출
	 * - 객체의 초기화를 담당
	 * - 클래스에 생성자가 선언되어 있지 않다면 컴파일러가 인자가 없고 내용이 없는 생성자를 
	 * 	  컴파일시 추가한다 ==> Default Constructor
	 *   => 클래스 내에 생성자가 있다면 컴파일러는 Default Constructor를 추가하지 않는다
	 *   
	 * - Constructor Overloading
	 *   인자(개수,타입,순서)가 다른 생성자를 1개 이상 선언할 수 있다
	 *   
	 */
	public customer() {
//		생성자가 있어도 기본값 하나 있는것이 좋다
//		생성자 overloading
//		생성자 call은 new를 통해서만 가능
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public customer(String name, int age, String address) {
//		생성자(선언을 안해도 컴파일러가 자동적으로 생성)
//		new에 의해서만 생성자 호출
		/*
		 * this : this를 사용한 클래스로 부터 생성된 객체 중 현재 사용중인 객체를 참조한다
		 * 1. 로컬변수와 속성 이름이 같을 떄 구별하기 위해 속성 앞에 this.을 붙인다
		 * 2. 코드 재사용을 위해서 인자가 다른 생성자를 호출 할 때
		 *    this(~);
		 *    주의점 : 생성자 호출은 생성자의 첫번째 명령에서만 가능하다
		 * 3. 클래스 내에서 해당 클래스의 객체가 필요한 경우
		 *    ex) 이벤트 처리시
		 */
//		toggle block section
		this.name=name;
		this.age=age;
		this.address=address;
	}
	public boolean equals(customer cust) {
		return this == cust;	// 3. 클래스 내에서 해당 클래스의 객체가 필요한 경우
	}
	public String customerInfo() throws RuntimeException{
		return "이름:"+getName()+" 나이:"+getAge()+" 주소:"+getAddress();
//		컴파일시에 자동적으로 this.를 붙여준다
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("customer [name=").append(name).append(", age=").append(age).append(", address=").append(address)
				.append("]");
		return builder.toString();
	}
	

}
