package fillCell;
import java.util.Scanner;
/**
 * 여러개의 좌표를 입력 받아 해당 좌표의 상하좌우에  1을 표시하기 
 * 입력 :
 *  다음줄 부터 :  배열의 개수  좌표개수  {row좌표, column좌표}*좌표개수
 *  8 4 1 1 3 1 3 3 4 2
 * 
 */
public class FillCell05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		int p = sc.nextInt();  //좌표 개수
		int[] r = new int[p];
		int[] c = new int[p];
		for(int i=0;i<p;i++) {
			r[i]=sc.nextInt();
			c[i]=sc.nextInt();
		}
		int[] dirR= {-1,1,0,0};		//행 좌표
		int[] dirC= {0,0,-1,1};		//열 좌표
		for(int j=0;j<p;j++) {
			for(int i=0;i<4;i++) {
				int nr = r[j]+dirR[i];
				int nc = c[j]+dirC[i];
				
				if(0<=nr && nr<N && 0<=nc && nc<N ) {
					map[nr][nc]=1;
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
