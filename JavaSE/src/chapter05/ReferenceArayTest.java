package chapter05;

import java.util.Arrays;

public class ReferenceArayTest {

	public static void main(String[] args) {
		Employee emp = new Employee("2", "ssafy", 5000);
		
		Employee[] emps = new Employee[3];
		System.out.println(Arrays.toString(emps));
		emps[0] = new Employee("1", "홍길동", 5000);
		emps[1] = emp;
		System.out.println(Arrays.toString(emps));
	}

}
