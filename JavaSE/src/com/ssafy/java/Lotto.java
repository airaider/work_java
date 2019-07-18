package com.ssafy.java;

import java.util.Arrays;
import java.util.Random;

public class Lotto {
	static void uniqueValue(int index, int[] data) {
		if(data!=null && index < data.length) {
			int temp;
			boolean isdupl;
			Random ran = new Random();
			do {
				temp=ran.nextInt(45)+1;		//로또 번호 생성 1~45사이의 난수로 생성
				isdupl = false;
				for (int i = 0; i < index; i++) {
					if(temp==data[i]) {
						isdupl=true;
						break;
					}
				}
			}while(isdupl);
			data[index]=temp;
		}
	}
	public static void main(String[] args) {
		int num=6;
		int[] lotto = new int[num];
		for (int i = 0; i < num; i++) {
			uniqueValue(i,lotto);
		}
		System.out.println(Arrays.toString(lotto));
		
	}

}
