package chapter03;

import java.util.Scanner;

public class forTest2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("진열할 총 상품수를 입력하세요");
		int total = scan.nextInt();
		System.out.println("한 라인에 진열할 상품 수를 입력하세요");
		int num = scan.nextInt();
		int line=total/num;
		int mod=total%num;
//		int tot=total;
//		int de=total%num;
//		for (int i = 0; i < total/num+de; i++) {
//			if(i==total/num+de-1) {
//				for(int j=0;j<de;j++) {
//					System.out.print("@ ");
//				}
//				break;
//			}
//			for (int j=0;j<num;j++) {
//				System.out.print("@ ");
//			}
//			System.out.println();
//		}
		
		line=mod==0 ? line:line+1;
		for(int i=1;i<=line;i++) {
			for(int j=0;j<num;j++) {
				System.out.print("@ ");
				if(--total==0) {
					break;
				}
			}
			System.out.println();
		}
		
	}
}
