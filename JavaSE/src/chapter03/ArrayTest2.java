package chapter03;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ArrayTest2 {

	public static void main(String[] args) {
		String[] names = {"a1","a2","a3","a4","a5","a6"};
		int[] java = {90,95,100,93,91,90};
		int[] db = {100,90,90,95,91,100};
		int[] front = {95,100,90,93,100,95};
		int[] algo = {90,90,99,93,95,93};
		
		int[] total = new int[names.length];
		double[] avg = new double[names.length];
		double n=4;
		
		System.out.println("======================================================");
		System.out.println("이름\tjava\tdb\tfront\talgo\t총점\t평균");
		System.out.println("======================================================");
		PriorityQueue<Double> pq = new PriorityQueue<Double>();
		for (int i = 0, size=names.length; i < size; i++) {
			total[i]=java[i]+db[i]+front[i]+algo[i];
			avg[i]=total[i]/n;
			pq.add(avg[i]);
			System.out.printf("%s\t%d\t%d\t%d\t%d\t%d\t%.2f\n"
					,names[i]
					,java[i]
					,db[i]
					,front[i]
					,algo[i]
					,total[i]
					,avg[i]
					);
			
		}
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
		
		
	}

}
