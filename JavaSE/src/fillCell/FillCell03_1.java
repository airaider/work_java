package fillCell;
import java.util.Scanner;
/**
 * 배열 개수와 좌표를 입력 받아 해당 좌표에 상하좌우에 1을 표시한후 전체 배열을 화면에 출력
 * 경계 검사
 * 
 * 입력 : 
 *  배열의 개수   row좌표, column좌표
 *  ex) 3 0 0 
 * 
 */
public class FillCell03_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		int r = sc.nextInt();
		int c = sc.nextInt();
		int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}
		};
		////////////////
		/// 처리 코드 작성
		int[] dirR= {-1,1,0,0};		//행 좌표
		int[] dirC= {0,0,-1,1};		//열 좌표
		for(int i=0;i<4;i++) {
			int nr = r+dirR[i];
			int nc = c+dirC[i];
			
			if(0<=nr && nr<N && 0<=nc && nc<N ) {
				map[nr][nc]=1;
			}
		}

	}
}
