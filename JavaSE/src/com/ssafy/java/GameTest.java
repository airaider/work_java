package com.ssafy.java;

import java.util.Scanner;

public class GameTest {
	static int cw=0;
	static int hw=0;
	static int cnt=0;
	static int h;
	static int result;
	static int c;
	static int max;
	static int maxwin;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
		System.out.println("1. 5판 3승");
		System.out.println("2. 3판 2승");
		System.out.println("3. 1판 1승");
		System.out.print("번호를 입력하세요.");
		int T=scan.nextInt();
		switch (T) {
		case 1:
			max=5;
			maxwin=3;
			break;
		case 2:
			max=3;
			maxwin=2;
			break;
		case 3:
			max=1;
			maxwin=1;
			break;

		default:
			break;
		}
		
		while(cnt<max) {
			System.out.println("가위바위보 중 하나 입력(1가위, 2주먹, 3보): ");
			h=scan.nextInt();
			c=(int)(Math.random()*3)+1;
			result=h-c;
			if(result==0) {
				System.out.println("비겼습니다!!!");
				continue;
			}
			else if(Math.abs(result)==1) {
				if(result>0) {
					System.out.println("이겼습니다!!!");
					++hw;
				}
				else {
					System.out.println("졌습니다!!!");
					++cw;
				}
			}
			else {
				if(result<0) {
					System.out.println("이겼습니다!!!");
					++hw;
				}
				else {
					System.out.println("졌습니다!!!");
					++cw;
				}
			}
			if(hw==maxwin) {
				System.out.println("### 인간 승!!!");
				break;
			}
			else if(cw==maxwin) {
				System.out.println("### 컴퓨터 승!!!");
				break;
			}
			++cnt;
		}
	}

}
