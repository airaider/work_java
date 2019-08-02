package com.ssafy.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
	static class EmployeeComparator implements Comparator<Employee>{

		@Override
		public int compare(Employee arg0, Employee arg1) {
			//연봉기준 내림차순, 사번 기준 오름차순
			int result = -(arg0.getSalary()-arg1.getSalary());
			if(result==0) {
				 return arg0.getEmpno().compareTo(arg1.getEmpno());
			}
			return result;
		}
		
	}
	
	static class EmComparator implements Comparator<Employee>{

		@Override
		public int compare(Employee o1, Employee o2) {
			int result = o1.getSalary()-o2.getSalary();
			return o1.getEmpno().compareTo(o2.getEmpno());
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
			new Engineer("190001", "김태희", 10,"java"),
			new Engineer("190004", "비", 20, "algorithm"),	
			new Manager("190003", "김재환", 20, "프로"),	
		};
		Arrays.sort(list, new EmployeeComparator());
		for (Employee employee : list) {
			System.out.println(employee);
		}
		
		ArrayList<Employee> eList = new ArrayList<Employee>();
		eList.add(new Engineer("190001", "김태희", 10,"java"));
		eList.add(new Engineer("190004", "비", 20, "algorithm"));
		eList.add(new Manager("190003", "김재환", 20, "프로"));
		
		Collections.sort(eList, new EmployeeComparator());
//		Collections.sort(eList);
		for (Employee employee : eList) {
			System.out.println(employee);
		}
		
		Collections.sort(eList, new EmComparator());
		
	}

}
