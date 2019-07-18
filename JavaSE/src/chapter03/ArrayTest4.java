package chapter03;

import java.util.Arrays;

public class ArrayTest4 {

	public static void main(String[] args) {
//		배열 크기를 변경할 수 없으므로 변경이 필요하다면 개로 생성해서 복사해야 한다
		/*
		 * System.arraycopy(src, srcPos, dest, destPos, length);
		 * 배열을 전체 또는 부분 카피하는 기능
		 * src : 복사할 원본
		 * srcPos : 원본의 복사 위치
		 * dest : 부본 (copy본)
		 * destPos : 부본의 복사할 위치
		 * len : 복사할 데이터 개수 
		 */
		
		int[] src = {0,1,2,3,4,5,6,7,8,9};
		
		int[] copy1 = new int[15];
		int[] copy2 = new int[3];
		
		System.arraycopy(src, 0, copy1, 0, src.length);
		System.out.println(Arrays.toString(copy1));
		System.arraycopy(src, 3, copy2, 0, copy2.length);
		System.out.println(Arrays.toString(copy2));
		
		
		/*
		 * Arrays.copyOf(original, newLength);
		 * newLength 크기의 배열을 생성해서 새로운 배열에 original의 값을 복사해서 리턴
		 */
		System.out.println(Arrays.toString(Arrays.copyOf(src, src.length+7)));
		
		/*
		 * Arrays.copyOfRange(original, from, to)
		 * original 배열의 값중 from위치의 데이터 부터 to 위치의 데이터까지 복사해서 리턴
		 */
		System.out.println(Arrays.toString(Arrays.copyOfRange(src, 3, 6)));
		
		
	}

}
