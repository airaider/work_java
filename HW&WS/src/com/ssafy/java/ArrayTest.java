package com.ssafy.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ArrayTest {
	static int total(int[] a2) {
		int sum=0;
		for (int i = 0; i < a2.length; i++) {
			sum += a2[i];
		}
		return sum;
	}
	static int min(int[] a2) {
		int min=a2[0];
		for (int i = 0; i < a2.length; i++) {
			if(a2[i]<min) min=a2[i]; 
		}
		return min;
	}
	static double avg(int[] a3) {
		double avg = total(a3)/a3.length;
		return avg;
	}
	
	static int[] a;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = new int [st.countTokens()];
		for (int i = 0; i < a.length; i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
		System.out.println("배열의 합 : "+total(a));
		System.out.println("배열의 평균 : "+(int)avg(a));
		System.out.println("배열의 최소값 : "+min(a));
		
		

		
	}

}


/*
34 23 64 24 12 75 22 88 53 37
*/