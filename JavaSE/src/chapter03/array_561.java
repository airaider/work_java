	package chapter03;
	
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.PriorityQueue;
	import java.util.Scanner;
	import java.util.StringTokenizer;
	
	public class array_561 {
		static int[] ar;
		public static void main(String[] args) throws IOException {
			Scanner sc = new Scanner(System.in);
			int min=0;
			int max=10001;
			ar = new int[10];
			for(int i=0;i<10;i++) {
				ar[i]=sc.nextInt();
			}
			for(int i=0;i<10;i++) {
				if(ar[i]<100) {
					if(ar[i]>min) {
						min=ar[i];
					}
				}
				else {
					if(ar[i]<max) {
						max=ar[i];
					}
				}
			}
			if(min==0) {
				min=100;
			}
			if(max==10001) {
				max=100;
			}
			System.out.println(min+" "+max);
		}
	
	}
