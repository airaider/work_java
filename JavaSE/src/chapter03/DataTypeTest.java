package chapter03;

public class DataTypeTest {

	public static void main(String[] args) {

		/*
		 * 
		 * 
		 * 
		 */
		byte b1=1, b2=3;
//		byte b3 = b1+b2;
		
		
		long l1 = 127;
//		long l2 = 2222222222;
//		int범위를 벗어난 정수 숫자는 long타입(l, L)임을 표시해야 한다.
		long l2 = 2222222222l, l3 = 222222222222L;
		
		
//		실수는 double이 기본 타입이므로 float인 경우 f, F로 표시해야 한다.		
		float f1=3.14f, f2=3.14F;
		float f3 = 65536.256f;
		System.out.println("f1: "+f1);
		System.out.println("f2: "+f3);
		
		double d1 = 3.14, d2=3.14d, d3=3.14D;
		double d4 = 3.123456787901234567890;
		System.out.println("d4: "+d4);
		
		char c1='a';
		
		boolean bl1 = true;
		
		
		
	}

}
