package chapter03;

public class ArrayTest1 {

	public static void main(String[] args) {
		int[] a1;
		//배열을 생성하면 기본 값으로 초기화 된다. 정수:0 실수:0.0 논리:false 문자:\u0000 reference:null
		a1 = new int[3];
		for (int i = 0; i < a1.length; i++) {
			System.out.printf("a1[%d] : %d\n",i,a1[i]);
		}
	}

}
