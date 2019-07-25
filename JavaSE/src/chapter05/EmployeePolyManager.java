package chapter05;

import java.util.Arrays;

public class EmployeePolyManager {
	/**
	 * 다형성을 배열에 적용
	 * 다형성에 의해 모든 sub 타입은 super 타입으로 형변환이 자동으로 되기 때문에
	 * super타입의 배열 하나만 선언하면 sub타입의 객체도 저장할 수 있다
	 */
	private Employee[] emps;
	/**다음 저장 위치, 현재 저장된 수*/
	private int empIndex; 
	
	public EmployeePolyManager() {
		emps = new Employee[15];
	}
	/**
	 * 사원번호에 해당하는 사원 정보가 저장된 배열의 index를 리턴
	 * @param empno 찾을 사원 번호
	 * @return		사원 번호에 해당하는 사원이 저장된 index를 리턴
	 */
	public int findIndex(String empno) {
		if(empno != null) {
			for (int i = 0; i < empIndex; i++) {
				if(empno.equals(emps[i].getEmpno()))
				return i;
			}
		}
		return -1;
	}
	/**
	 * 다형성을 리턴타입에 적용
	 * 다형성에 의해 모든 sub타입은 super로 형변환이 자동으로 되기 때문에
	 * 리턴 타입을 super로 선언하면 sub도 리턴할 수 있다
	 * public Employee getEmployee() {
		return new Manager();
		}
	 */
	public Employee getEmployee() {
		return new Manager();
	}
	/**사원번호에 해당된 사원을 찾아서 정보를 리턴하는 기능의 함수*/
	public Employee search(String empno) {
		int index = findIndex(empno);
		if(index>-1) {
			return emps[index];
		}
		else
			return null;
	}
	
	/**
	 * 다형성을 메서드 인자에 적용
	 * 다형성에 의해 모든 sub 타입은 super로 형변환이 자동으로 되기 때문에
	 * 매서드 인자를 super타입으로 선언하면 모든 sub타입의 객체도 인자로 전달 받을 수 있다.
	 * ==> 매서드 Overloading을 줄일 수 있다
	 */
	public void add(Employee emp) {
		System.out.println("Employee를 저장합니다.");
		if(emp != null) {
			String empno = emp.getEmpno();
			int index = findIndex(empno);
			if(index > -1) {
				System.out.println("이미 등록된 사원번호입니다.");
			}else {
				if(empIndex >= emps.length) {
					emps = Arrays.copyOf(emps, empIndex+5);
				}
				emps[empIndex++] = emp;
			}
		}
	}
	
	public void update(Employee emp) {
		if(emp != null) {
			String empno = emp.getEmpno();
			int index = findIndex(empno);
			if(index>-1) {
				emps[index] = emp;
			}else {
				System.out.println("수정할 사원번호가 등록되지 않았습니다.");
			}
		}else {
			System.out.println("수정할 사원의 정보를 입력해 주세요");
		}
	}
	public void remove(String empno) {
		int index = findIndex(empno);
		if(index > -1) {
			emps[index]=emps[--empIndex];
		}else {
			System.out.println("삭제할 사원번호가 등록되지 않았습니다.");
		}
	}
	public void print() {
		for (int i = 0; i < empIndex; i++) {
			System.out.println(emps[i]); 		//virtual invoke **시험 문제**
		}
	}
}


