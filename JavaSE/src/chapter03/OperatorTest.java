package chapter03;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class OperatorTest {

	public static void main(String[] args) {
		/*
		 * >>						8 >> 2
		 * 비트를 오른쪽으로 이동	0000 1000    0000 0010
		 * 이동한 곳에는 sign bit가 채워짐
		 * 2의 n승으로 나눈 효과
		 */
		
		int num1 = 8;
		int num2 = -8;
		
		/*
		 * printf(String format, Object ...args)
		 * %s	String
		 * %d	정수
		 * %f	실수, 	%.소수자리수f(반올림 처리)
		 * %c	문자
		 * %b	논리
		 */
		System.out.printf("8 >> 2 : %d \n", num1 >> 2);
		System.out.printf("-8 >> 2 : %d \n", num2 >> 2);
		
		/*
		 * >>>
		 * 비트를 오른쪽으로 이동
		 * 왼쪽의 빈칸을 0으로 채움
		 */
		System.out.printf("8 >>> 2 : %d \n", num1 >> 2);
		System.out.printf("-8 >>> 2 : %d \n", num2 >>> 2);
		
//		DataOutputStream dos;
//		dos.writeLong(256);
//		DataInputStream(256);
//		dis.readLong();
		
		
		/*
		 * <<
		 * 비트를 왼쪽으로 이동
		 * 오른쪽의 빈칸에는 0을 채움
		 * 2의 n승을 곱한 효과
		 */
		System.out.printf("8 << 2 : %d \n", num1 << 2);
		System.out.printf("-8 << 2 : %d \n", num2 << 2);
		
		/*
		 * 						&&		&		||		|
		 * true		true		true	true	true	true
		 * true		false		false	false	true	true
		 * false	true		false	false	true	true
		 * false	false		false	false	false	false
		 */
		int i=10, j=5;
//		boolean result = i++>10 && j++>5;
		boolean result = i++>10 & j++>5;
		System.out.printf("result:%b i:%d j:%d", result, i, j);
		
	}

}
