package com.ssafy.java;

import java.util.Scanner;

public class AlphaTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char a='A';
		int cnt=0;
		int max;
		Scanner scan = new Scanner(System.in);
		max = scan.nextInt();
		for(int i=0;i<max;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print((char)(a+cnt)+" ");
				cnt++;
				
			}
			System.out.println();
		}
	}

}