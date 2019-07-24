package chapter04;

public class Access{
	private String myRoom;
	String usHouse;
	protected String myFamily;
	public String park;
	
	public Access(String myRoom, String usHouse, String myFamily, String park) {
		this.myRoom = myRoom;
		this.usHouse = usHouse;
		this.myFamily = myFamily;
		this.park = park;
	}

	public void print() {
		System.out.printf("room:%s	 house:%s	family:%s	park:%s\n"
				,myRoom, usHouse, myFamily, park);
	}
}
