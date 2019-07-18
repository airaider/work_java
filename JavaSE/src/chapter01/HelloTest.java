package chapter01;

import java.io.FileInputStream;

public class HelloTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");
		String str = "Hello";
		for (int i = 0; i < 2111111111; i++) {
			str += i;
			System.out.println(str);
		}
	}

}
