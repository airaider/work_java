package com.ssafy.java;

import java.util.Scanner;

public class AlphaTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char a='A';
		int cnt=0;
		int max;
		Scanner scan = new Scanner(System.in);
		max = scan.nextInt();
		for(int i=max;i>=1;i--) {
			for(int j=1;j<i;j++) {
				System.out.print(" ");
				System.out.print(" ");
			}
			for(int j=max;j>=i;j--) {
				System.out.print((char)(a+cnt)+" ");
				cnt++;
			}
			System.out.println();
		}
	}

}
