package com.ssafy.model.dto;

import java.io.Serializable;

public class Employee implements Serializable {
	private String empno;
	private String name;
	private int salary;
	
	public Employee() {
		
	}

	public Employee(String empno, String name, int salary) {
		this.empno = empno;
		this.name = name;
		setSalary(salary);
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		if(salary<=0) {
			System.out.println("0원 이상의 급여를 입력하세요");
		}else this.salary = salary;
		
	}
	/**
	 * 객체의 내용이나 객체를 대표하는 문자여를 리턴
	 * - System.out으로 출력할 때 호출된다
	 * - 문자열 + 객체 => toString()를 호출해서 리턴되는 문자열을 연결시킨다
	 * - 필요시에 override
	 * - override하지 않으면 class명@hashcode가 리턴된다
	 */
	
	public String toString() {
		return "사원번호:"+getEmpno()+" 이름:"+getName()+" 급여:"+getSalary();
	}
	
	/**
	 * 객체의 내용을 비교하는 기능
	 * - 객체의 내용을 비교해야 한다면 반드시 override 해야 한다
	 * 
	 */
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Employee) {
			Employee emp = (Employee) obj;
			if(empno!=null && empno.equals(emp.empno)) {
				return true;
			}
			
		}
		return false;
	}
	
	public void test() {
		System.out.println("Employee test함수 입니다");
	}
	protected void service() {
		System.out.println("Employee service함수 입니다");
	}
}
