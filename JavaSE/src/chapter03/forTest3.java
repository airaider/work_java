package chapter03;

import java.util.Scanner;

public class forTest3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int line = scan.nextInt();
		
		for (int i = 1; i <= line; i++) {
			for (int j = 1; j <=i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
		for (int i = line; i >= 1; i--) {
			for (int j = 1; j <=i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}
