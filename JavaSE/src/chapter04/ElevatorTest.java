package chapter04;

public class ElevatorTest {
	public static void main(String[] args) {
		Elevator e1 = new Elevator(1, 6, -3, true);
		e1.choose(3);
		System.out.println("===============");
		e1.choose(1);
		System.out.println("===============");
		e1.choose(1);
		e1.choose(-6);
	}
}
