package com.ssafy.step2.movie;

import java.util.Arrays;

import com.ssafy.step1.car.Car;

public class MovieMgr {
	private Movie[] mov = new Movie[10];
	private int mindex;
	private static MovieMgr instance = new MovieMgr();
	
	private MovieMgr() {
	}
	public static MovieMgr getInstance() {
		return instance;
	}
	
	public void search(String title) {
		int flag=-1;
		if(title != null) {
			for (int i=0;i<mindex;i++) {
				if(title.equals(mov[i].getTitle())) {
					System.out.println(mov[i]);
					flag++;
				}
			}
		}
		if(title !=null && flag==-1) {
			System.out.println("해당 영화를 찾을 수 없었습니다.");
		}
		else {
			for(int i =0;i<mindex;i++) {
				System.out.println(mov[i]);
			}
		}
		
	}
	public int findIndex(String num) {
		if(num != null) {
			for (int i=0;i<mindex;i++) {
				if(num.equals(mov[i].getTitle()))
					return i;
			}
		}
		return -1;
	}
	public void searchDirector(String num) {
		int index = -1;
		if(num != null) {
			for(int i =0;i<mindex;i++) {
				if(num.contains(mov[i].getDirector())) {
					System.out.println(mov[i]);
					index++;
				}
			}
		}
		if(index==-1) {
			System.out.println("해당 영화 감독의 작품이 없습니다.");
		}
	}
	public void searchGenre(String num) {
		int index = -1;
		if(num != null) {
			for(int i =0;i<mindex;i++) {
				if(num.contains(mov[i].getGenre())) {
					System.out.println(mov[i]);
					index++;
				}
			}
		}
		if(index==-1) {
			System.out.println("해당 장르의 영화가 없습니다.");
		}
	}
	public void add(Movie art) {
		System.out.println("영화를 저장합니다.");
		if(art != null) {
			String num = art.getTitle();
			int index = findIndex(num);
			if(index > -1) {
				System.out.println("이미 등록된 영화입니다.");
			}else {
				if(mindex >= mov.length) {
					mov = Arrays.copyOf(mov, mindex+10);
				}
				mov[mindex++] = art;
			}
		
		}
	}
	public void delete(String title) {
		int index = findIndex(title);
		if(index > -1) {
			mov[index]=mov[--mindex];
			System.out.println('"'+title+'"'+"영화를 삭제했습니다");
		}
		else {
			System.out.println("삭제할 영화를 찾지 못했습니다.");
		}
	}
	public int getSize() {
		return mindex;
	}
}
