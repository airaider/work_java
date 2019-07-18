package chapter03;

import java.util.Arrays;
import java.util.PriorityQueue;
/**
 * 다차원 배열
 * [] 차원 표시
 * {} 데이터 할당할 때 차원 표시
 *
 */
public class ArrayTest3 {

	public static void main(String[] args) {
		int[][] a = new int[2][3];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.printf("a[%d][%d]:%d ", i, j, a[i][j]);
			}
			System.out.println();
		}
		
		int[][] a2 = new int[3][];
		a2[0]=new int[5];
		a2[1]=new int[1];
		a2[2]=new int[3];
		for (int i = 0; i < a2.length; i++) {
			System.out.println(Arrays.toString(a2[i]));
		}
		for (int i = 0; i < a2.length; i++) {
			for (int j = 0; j < a2[i].length; j++) {
				System.out.printf("a[%d][%d]:%d ", i, j, a2[i][j]);
			}
			System.out.println();
		}
		
		
	}

}
