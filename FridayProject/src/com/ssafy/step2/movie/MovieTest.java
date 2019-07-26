package com.ssafy.step2.movie;

import java.util.Scanner;

public class MovieTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MovieMgr m1 = MovieMgr.getInstance();
		int n=-1;
		System.out.println("<<< 영화 관리 프로그램 >>>");
		System.out.println("1. 영화 정보 입력");
		System.out.println("2. 영화 정보 전체 검색");
		System.out.println("3. 영화명 검색");
		System.out.println("4. 영화 장르별 검색");
		System.out.println("5. 영화 정보 삭제");
		System.out.println("0. 종료");
		while(n!=0) {
			System.out.println("원하는 번호를 선택하세요._\n");
			n=sc.nextInt();
			sc.nextLine();
			switch (n) {
			case 1:
				String title;
				String director;
				int grade;
				String genre;
				String summary;
				System.out.println("영화 정보를 입력합니다");
				System.out.println("제목 : ");
				title=sc.nextLine();
				System.out.println("감독 : ");
				director=sc.nextLine();
				System.out.println("시청연령 : ");
				grade=sc.nextInt();
				System.out.println("장르 : ");
				sc.nextLine();
				genre=sc.nextLine();
				System.out.println("요약 : ");
				summary=sc.nextLine();
				System.out.println();
				System.out.printf("%s, %s, %d, %s, %s",title,director,grade,genre,summary);
				m1.add(new Movie(title, director, grade, genre, summary));
				System.out.println("영화가 등록되었습니다!");
				break;
			case 2:
				System.out.println("전체 영화를 검색합니다");
				m1.search(null);
				break;
			case 3:
				System.out.println("영화 제목을 검색합니다. 검색할 영화 제목을 입력하세요.");
				String st;
				st=sc.nextLine();
				m1.search(st);
				break;
			case 4:
				System.out.println("장르별 영화를 검색합니다. 검색할 영화 장르를 입력하세요.");	
				String st1;
				st1=sc.nextLine();
				m1.searchGenre(st1);
				break;
			case 5:
				System.out.println("영화를 삭제합니다. 삭제할 영화 제목을 입력하세요.");	
				String st2;
				st2=sc.nextLine();
				m1.delete(st2);
				break;
			case 0:
				System.out.println("영화 관리 프로그램을 종료합니다.");
				break;

			default:
				System.out.println("잘못된 번호를 입력했습니다. 다시 입력해주세요.");
				break;
			}
		}
	}

}
