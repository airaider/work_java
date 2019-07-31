package chapter05;

public class Employee {
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
//	public String toString() {
//		return "사원번호:"+getEmpno()+" 이름:"+getName()+" 급여:"+getSalary();
//	}
	public void test() {
		System.out.println("Employee test함수 입니다");
	}
	public int hashCode() {
		int empnoHash = empno !=null ? empno.hashCode() :1;
		int nameHash = name !=null? name.hashCode():1;
		return empnoHash ^ nameHash ^ salary;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(50);
		builder.append("Employee [empno=").append(empno).append(", name=").append(name).append(", salary=")
				.append(salary).append("]");
		return builder.toString();
	}

	protected void service() {
		System.out.println("Employee service함수 입니다");
	}
}
