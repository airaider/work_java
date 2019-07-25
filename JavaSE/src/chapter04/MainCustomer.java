package chapter04;

public class MainCustomer extends customer {
	private String hobby;
	public MainCustomer() {
		
	};
	public MainCustomer(String name, int age, String address, String hobby) {
		this.name=name;			/**상속 받은 속성*/
		this.age=age;			/**상속 받은 속성*/
		this.address=address;	/**상속 받은 속성*/
		this.hobby=hobby;		
	}
}
