package com.ssafy.sort;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

import com.ssafy.model.dto.Employee;
import com.ssafy.model.dto.Engineer;
import com.ssafy.model.dto.Manager;

public class ArraySortTest {

	static class IntComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			return -(o1-o2);
//			return o1.compareTo(o2);
		}
		
	}
	
	public static void main(String[] args) {
//		int[] arr = {2,40,3,2,10};
//		System.out.println(Arrays.toString(arr));
//		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
//		
//		Integer[] arr2 = {2,40,3,2,10};
//		System.out.println(Arrays.toString(arr2));
//		Arrays.sort(arr2, new IntComparator());
//		System.out.println(Arrays.toString(arr2));
//		
//		
		Employee[] list = new Employee[] {
			new Engineer("190001", "김태희", 2000000000,"java"),
			new Engineer("190002", "비", 1000000000, "algorithm"),	
			new Manager("190003", "김재화", 500000000, "프로"),	
		};
		
		
	}

}
