package chapter03;

import java.util.Arrays;

/**
 * 자바는 변수에 값을 전달할 때, 인자에 값을 전달할 때, 리턴 값을 전달할 때 Pass By Value 형식 한가지 방식으로 전달한다.
 * 
 * Pass By Value : 변수를 위해 할당된 메모리에 있는 값을 전달
 * - Primitive type : 변수를 위해 할당된 메모리에 실제 값이 저장 됨
 * 	=> 변수, 인자, 리턴 값을 전달할 때 값이 전달 됨 ==> Pass By Value
 * - Reference type : 변수를 위해 할당된 메모리에 참조 값(hash code)이 저장 됨
 * 	=> 변수, 인자, 리턴 값을 전달할 때 참조 값(hash code)이 전달 됨 ==> Pass By Reference
 * 
 */
public class PassByValueTest {
	public static int[] passRefer2(int[] a, int offset, int len) {
		if(a != null && offset+len < a.length) {
			int[] newData = new int[len];
			for (int i = 0; i < newData.length; i++) {
				newData[i] = a[offset+i];
			}
			return newData;
		}
		return null;
	}
	public static int passValue(int a) {
		System.out.println("passValue>>>>>>>>>>>>>>>a : "+a);
		a+=10;
		return a;
	}
	public static void passRefer1(int[] a) {
		if(a!=null && a.length>0) {
			a[0]=10;
		}
	}
	public static void main(String[] args) {
		int[] data1= {0,1,2,3,4,5};
		System.out.println(Arrays.toString(passRefer2(data1,2,3)));
		
		
		int[] data= {0,1,2,3,4,5};
		System.out.println(Arrays.toString(data));
		passRefer1(data);
		System.out.println(Arrays.toString(data));
		
		int pri = 10;
		System.out.println(passValue(pri));
		System.out.println(pri);
	}

}
