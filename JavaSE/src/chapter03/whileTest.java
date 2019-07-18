package chapter03;

import java.util.Scanner;

public class whileTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n;
		int sum=0;
		double count=0;
		while(true) {
			n=scan.nextInt();
			sum+=n;
			++count;
			if(n>=100) 
				break;
		}
		System.out.println(sum);
		System.out.printf("%.1f", sum/count);
	}

}

//		1 2 3 4 5 6 7 8 9 10 100

