package chapter07;

import java.util.ArrayList;
import java.util.LinkedList;

import chapter05.Employee;
import chapter05.Manager;

/**
 * List
 * - 저장한 순서대로 저장된다.
 * - index는 0번부터 size()-1까지
 * - 중복 저장이 됨
 * - 중간 삽입할 경우 0번부터 size()까지
 *   범위를 벗어나면 IndexOutOfBoundsExecption발생
 */

public class ListTest {
	public static void main(String[] args) {
//		ArrayList list1 = new ArrayList();
		LinkedList list1 = new LinkedList();
		list1.add("hello");
		list1.add(256);
		list1.add(3.14);
		list1.add(new Employee("1", "ssafy", 100));
		list1.add(3, true);
		System.out.println(list1);
		
//		get(int index) : index번째 해당하는 데이터 추출
		System.out.println("3's index : "+list1.get(3));
		
		/**
		 * indexOf(Object o), lastIndexOf(Object o), contains(Object o), remove(Object o) 함수는
		 * 해당 기능을 수행하기 위해 equals(Object o)를 호출해서 객체 비교한다
		 */
		int index = list1.indexOf(true);
		System.out.println("index:"+index);
		
		/**
		 * java5부터 Collection에 Generic을 적용
		 * - 생성할때 지정한 type만 저장한다
		 * - 추출시 형변환을 할 필요가 없다
		 */
		ArrayList<Employee> emps = new ArrayList<Employee>();	//Generic 타입지정에는 다형성 지원 불가
		emps.add(new Employee("1", "ssafy", 300));
		emps.add(new Manager("2", "홍길동", 300, "대리"));	//데이터 저장시에는 다형성 적용
		System.out.println(emps);
		Employee emp = emps.get(0);
		System.out.println(emp);
		
	}

}
