package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DigitTest1 {
	static int stoi(String s) { return Integer.parseInt(s);}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int size=st.countTokens();
		int[] arr = new int[size];
		int[] dig = new int[10];
		for (int i = 0; i < size; i++) {
			arr[i]=stoi(st.nextToken());
		}
		for (int i = 0; i < size; i++) {
			if(arr[i]==0) continue;
			dig[arr[i]/10]++;
		}
		for (int i = 0; i < 10; i++) {
			if(dig[i]!=0) {
				System.out.println(i+" : "+dig[i]+"개");
			}
			
		}
	}

}

/*
10 55 2 63 85 61 85 0
*/