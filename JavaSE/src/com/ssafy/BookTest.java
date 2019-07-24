package com.ssafy;

public class BookTest {

	public static void main(String[] args) {
		Book jp = new Book("21424","Java Pro","김하나","Jaen.kr",15000,"Java 기본 문법");
		Book bs = new Book("35355","분석 설계","소나무","Jaen.kr",30000,"SW 모델링");
		Magazine jw = new Magazine("35535","Java World","편집부","Java.com",2018,2,30000,"SW 모델링");
		
		System.out.println("*********************** 도서목록 ***********************");
		System.out.println(jp.toString());
		System.out.println(bs.toString());
		System.out.println(jw.toString());
	}

}
