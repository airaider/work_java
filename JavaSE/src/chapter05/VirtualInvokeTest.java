package chapter05;

import chapter05.sub.RnD;

public class VirtualInvokeTest {

	public static void main(String[] args) {
		Employee emp = new RnD();
		
		emp.test();
		emp.service();
	}

}
