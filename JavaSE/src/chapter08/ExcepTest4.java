package chapter08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 2. 선언적 예외 처리
 * 	- 메소드 호출한 곳으로 어류 던져서, 메서드 호출한 곳에서 예외 처리하도록 위임
 *  - 메소드 선언부에 예외 처리
 *  [modifiers] 리턴타입 메도스명([인자들])[throws 예외, ...]{
 *  }
 *	목적.
 *	1.오류가 발생한 곳에서 직접 처리하면 처리방법이 고정되므로 상황에 맞게 처리가 안됨
 *	> 호츌한 곳의 상황에 맞게 처리하도록 위임 => 처리방법의 다양성
 *	2.한 프로그램의 수많은 기능에서 다양한 오류가 발생하지만
 *		처리 방법은 동일한 경우 오류가 발생한 곳마다 처리하면
 *		코드 재사용성이 떨어지므로 호출한 곳으로 던져서 한번에 처리한다
 *		(UI : 이벤트 처리하는 곳, Server : 클라이언트 요청 처리하는 곳)
 *	3.프로그램 수행중 정상 처리된 결과는 return을 통해 전달하고
 *		비정상적인 상황은 예외를 통해 전달한다
 *
 *	- 오류 발생 시키기
 *	throw 오류 객체
 */
class MyUtil{
	public static int div(int i, int j) throws Exception {
		if(j!=0) {
			return i/j;
		}
		else {
//			CheckedException은 반드시 예외 처리해야 한다
			throw new Exception("0으로 나눌수 없습니다.");
		}
	}
	public static int mod(int i, int j) {
		if(j!=0) {
			return i/j;
		}
		else {
//			UncheckedException은 예외 처리 하지 않아도 컴파일 에러가 발생하지 않기 때문에 필요할 때만 예외 처리한다
			throw new RuntimeException("0으로 나눌수 없습니다.");
		}
	}
	public static void load(String fileName) throws FileNotFoundException{
		FileInputStream fis = new FileInputStream(fileName);
	}
	
}

public class ExcepTest4 {

	public static void main(String[] args) {
		
		try {
			MyUtil.div(256, 0);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			MyUtil.mod(256, 0);
		}catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(MyUtil.mod(256, 4));
		
		try {
			MyUtil.load("a.txt");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			MyUtil.load("res/BaseStation.txt");
		} catch (FileNotFoundException e) {
			// 오류 발생한 위치를 모두 출력한다
			e.printStackTrace();
		}
		System.out.println("main end");
	}

}
