package chapter07;

import java.util.HashSet;

import chapter05.Employee;

public class SetTest {
/**
 * Set
 * - 데이터 중복을 허용하지 않음
 * - 저장한 순서대로 저장되지 않음
 * - index가 없음
 * - add(Object o_, contains(Object o), remove(Object o)에서 
 *   데이터가 중복됐는지 확인하기 위해 equals(Object o)와 hashCode()를 호출한다
 */
	public static void main(String[] args) {
		HashSet<Object> set1 = new HashSet<Object>();
		System.out.println(set1.add("hello"));
		System.out.println(set1.add("hello"));
		System.out.println(set1.add(new String("hello")));
		System.out.println(set1.add(256));
		System.out.println(set1.add(3.14));
		System.out.println(set1.add(new Employee("1", "ssafy", 300)));
		System.out.println(set1.add(new Employee("1", "ssafy", 300)));
		System.out.println(set1);
		
		for(Object obj : set1) {
			System.out.println(obj);
		}
		
	}

}
