package chapter05;

public class EmployeeTest {

	public static void main(String[] args) {
		EmployeePolyManager manager = new EmployeePolyManager();
		
		manager.add(new Employee("1", "ssafy", 5000000));
		manager.add(new Manager("2", "홍길동", 3000000,"대리"));
		manager.add(new Engineer("3", "고길동", 5000000,"둘리 괴롭히기"));
		System.out.println("==============등록 후 사원 정보=============");
		manager.print();
		manager.update(new Engineer("1", "ssafy", 7000000,"java"));
		System.out.println("==============수정 후 사원 정보=============");
		manager.print();
		manager.remove("1");
		System.out.println("==============삭제 후 사원 정보=============");
		manager.print();
		
		
		System.out.println(manager.search("1"));
		System.out.println(manager.search("2"));
		System.out.println(manager.search("3"));
		System.out.println(manager.search("4"));
	}

}
