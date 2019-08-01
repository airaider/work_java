package chapter08;

import chapter05.Employee;

/**
 * Excepetion Handling
 * - 프로그램 수행 중 오류가 발생하면 정상적으로 프로그램이 수행되도록 오류를 처리하는것
 * - 방법
 * 	1. 오류가 발생한 곳에서 직접 처리
 * 		try{
 * 			//오류가 발생될 코드
 * 		}catch(예외타입 인자명){
 *			//오류 처리
 * 		}catch(예외타입 인자명 || 예외타입 인자명){
 *			//오류 처리
 * 		}finally{
 * 			//try문이 수행되면 항상 수행된다
 * 			//반즈시 처리되야 하는 기능을 작성 ex) file, network, db등 자원을 사용후 반납 처리
 * 		}
 * 		
 * 	2. 선언적 예외 처리 
 * 	- 메소드 호출하는 곳으로 오류 던져서, 메서드 호출한 곳에서 예외 처리하도록 위임
 * 	- 메서드 선언부에 예외처리
 *
 */

public class ExcepTest {

	public static void main(String[] args) {
		try {
			Employee[] emps = new Employee[2111111111];
		}catch(Throwable e) {
			System.out.println("메모리 부족으로");
		}
		
		
		
		System.out.println("main end");
	}

}
