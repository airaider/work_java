package fillCell;
import java.util.Arrays;
import java.util.Scanner;
/**
 * 좌표에서 지정한 칸수까지 상하좌우로 1 채우기
 * 입력 :
 *  배열의 개수   row좌표, column좌표, 칸수
 *  ex) 8  1  1  3
 * 
 */
public class FillCell04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[][] map = new int[N][N];
		int r = sc.nextInt();
		int c = sc.nextInt();
		int count = sc.nextInt();
		int[] dirR= {-count,count,0,0};		//행 좌표
		int[] dirC= {0,0,-count,count};		//열 좌표
		
		for(int i=0;i<4;i++) {
			int nr = r+dirR[i];
			int nc = c+dirC[i];
			
			if(0<=nr && nr<N && 0<=nc && nc<N ) {
				for (int j = 0; j < count; j++) {
					map[r+j][c+j]=1;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
