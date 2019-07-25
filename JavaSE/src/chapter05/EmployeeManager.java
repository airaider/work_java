package chapter05;

import java.util.Arrays;

public class EmployeeManager {
	private Employee[] emps;
	private Manager[] mgrs;
	private Engineer[] engs;
	/**다음 저장 위치, 현재 저장된 수*/
	private int empIndex; /** 0 */
	private int mgrIndex; /** 0 */
	private int engIndex; /** 0 */
	
	public EmployeeManager() {
		emps = new Employee[15];
		mgrs = new Manager[5];
		engs = new Engineer[8];
	}
	
	/**사원번호에 해당된 사원을 찾아서 정보를 리턴하는 기능의 함수*/
	public String search(String empno) {
		if(empno != null) {
			for (int i = 0; i < empIndex; i++) {
				if(empno.equals(emps[i].getEmpno()))
				return emps[i].toString();
			}
			for (int i = 0; i < engIndex; i++) {
				if(empno.equals(engs[i].getEmpno()))
				return engs[i].toString();
			}
			for (int i = 0; i < mgrIndex; i++) {
				if(empno.equals(mgrs[i].getEmpno()))
				return mgrs[i].toString();
			}
		}
		return String.format("사원번호 %s번은 등록된 번호가 아닙니다. ", empno);
		
	}
	public void add(Employee emp) {
		System.out.println("Employee를 저장합니다.");
		if(emp != null) {
			String empno = emp.getEmpno();
			boolean isFind = false;
			if(!isFind) {
				for (int i = 0; i < empIndex; i++) {
					if(empno.equals(emps[i].getEmpno())) {
						isFind = true;
						break;
					}
					
				}
				for (int i = 0; i < engIndex; i++) {
					if(empno.equals(engs[i].getEmpno())) {
						isFind = true;
						break;
					}
						
				}
				for (int i = 0; i < mgrIndex; i++) {
					if(empno.equals(mgrs[i].getEmpno())) {
						isFind = true;
						break;
					}
				}
			}
			
			if(isFind) {
				System.out.println("이미등록된 사원번호입니다.");
			}else {
				if(empIndex >= emps.length) {
					emps = Arrays.copyOf(emps, empIndex+5);
				}
				emps[empIndex++] = emp;
			}
		}
	}
	public void add(Manager emp) {
		System.out.println("Manager를 저장합니다.");
		if(emp != null) {
			String empno = emp.getEmpno();
			boolean isFind = false;
			if(!isFind) {
				for (int i = 0; i < empIndex; i++) {
					if(empno.equals(emps[i].getEmpno())) {
						isFind = true;
						break;
					}
					
				}
				for (int i = 0; i < engIndex; i++) {
					if(empno.equals(engs[i].getEmpno())) {
						isFind = true;
						break;
					}
						
				}
				for (int i = 0; i < mgrIndex; i++) {
					if(empno.equals(mgrs[i].getEmpno())) {
						isFind = true;
						break;
					}
				}
			}
			
			if(isFind) {
				System.out.println("이미등록된 사원번호입니다.");
			}else {
				if(mgrIndex >= mgrs.length) {
					emps = Arrays.copyOf(mgrs, mgrIndex+5);
				}
				mgrs[mgrIndex++] = emp;
			}
		}
}
	public void add(Engineer emp) {
		System.out.println("Engineer를 저장합니다.");
		if(emp != null) {
			String empno = emp.getEmpno();
			boolean isFind = false;
			if(!isFind) {
				for (int i = 0; i < empIndex; i++) {
					if(empno.equals(emps[i].getEmpno())) {
						isFind = true;
						break;
					}
					
				}
				for (int i = 0; i < engIndex; i++) {
					if(empno.equals(engs[i].getEmpno())) {
						isFind = true;
						break;
					}
						
				}
				for (int i = 0; i < mgrIndex; i++) {
					if(empno.equals(mgrs[i].getEmpno())) {
						isFind = true;
						break;
					}
				}
			}
			
			if(isFind) {
				System.out.println("이미등록된 사원번호입니다.");
			}else {
				if(engIndex >= engs.length) {
					engs = Arrays.copyOf(engs, engIndex+5);
				}
				engs[engIndex++] = emp;
			}
		}
}
}

