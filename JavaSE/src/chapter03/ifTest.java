package chapter03;

import java.util.Scanner;

public class ifTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("점수를 입력하세요");
		int score = scan.nextInt();
		if(score <0 || score > 100) {
			System.out.println("점수를 잘못 입력했습니다. 0~100점 사이로 입력하세요");
		}
		else {
			System.out.printf("%d점은 ", score);
			if(score>=90) {
				System.out.println("A학점입니다");
			}
			else if(score>=80) {
				System.out.println("B학점입니다");
			}
			else if(score>=70) {
				System.out.println("C학점입니다");
			}
			else if(score>=60) {
				System.out.println("D학점입니다");
			}
			else {
				System.out.println("F학점입니다");
			}
			
			
		}
	}

}
