package com.java.first;

import java.util.Scanner;

public class CheckPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int a=scan.nextInt();
		int b=scan.nextInt();
		int c=b+100-a;
		System.out.printf("비만수치는 %d입니다.\n",c);
		if(c>0)
			System.out.println("당신은 비만이군요");
		
	}

}