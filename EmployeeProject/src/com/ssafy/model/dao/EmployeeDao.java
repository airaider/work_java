package com.ssafy.model.dao;

import java.util.List;

import com.ssafy.model.dto.Employee;

public interface EmployeeDao {

	/**
	 * 사원번호에 해당하는 사원 정보가 저장된 배열의 index를 리턴
	 * @param empno 찾을 사원 번호
	 * @return		사원 번호에 해당하는 사원이 저장된 index를 리턴
	 */
	int findIndex(String empno);

	/**사원번호에 해당된 사원을 찾아서 정보를 리턴하는 기능의 함수*/
	Employee search(String empno);

	/**
	 * 다형성을 메서드 인자에 적용
	 * 다형성에 의해 모든 sub 타입은 super로 형변환이 자동으로 되기 때문에
	 * 매서드 인자를 super타입으로 선언하면 모든 sub타입의 객체도 인자로 전달 받을 수 있다.
	 * ==> 매서드 Overloading을 줄일 수 있다
	 */
	void add(Employee emp);

	void update(Employee emp);

	void remove(String empno);
	
	void close();
	
	List<Employee> seachAll();

}