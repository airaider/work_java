package chapter04;

import java.util.Random;

public class PackageTest {

	public static void main(String[] args) {
		/*
		 * 캍은 package 내의 클래스를 참조할 경우에는 클래스명으로만 접근
		 */
		customer cust=new customer();
		
		/*
		 * 다른 package의 클래스를 참조할 때
		 * 1. package명.클래스명으로 접근한다
		 * 2. import문으로 클래스를 등록 후 클래스명으로 접근
		 * 	  import package명.클래스명;
		 * 	  import package.*;
		 */
		chapter03.DataTypeTest.main(null);
		
		Random ran = new Random();	//import 후 클래스명으로 접근
		
		
	}

}
