package chapter08;

/**
 * 사용자 정의 Exception
 * 
 * - UncheckedException
 * 	> 예외 처리하지 않아도 컴파일 오류가 발생하지 않은 오류들
 *  > 종류
 *  	-RuntimeException과 RuntimeException을 상속받은 sub들
 *  > 사용자 정의 UncheckedException 만들기
 *  	-RuntimeException이나 RuntimeException을 상속받은 sub들을 상속 받는다
 *  
 *  CheckedException
 * 	> 예외 처리하지 않으면 컴파일 오류가 발생해서 반드시 예외 처리해야 하는 오류
 *  > 종류
 *  	-RuntimeException과 RuntimeException을 상속받은 sub들을 제외한 예외들
 *  	ex) Exception, IOException
 *  > 사용자 정의 CheckedException 만들기
 *  	-RuntimeException이나 RuntimeException을 상속 받은 sub들을 뺀 예외들을 상속 받는다
 *  	ex) Exception
 */

class MyChecked extends Exception{
	public MyChecked() {
//		printStactTrace(), getMeassage()를 통해 ㅁ세지를 전달 받을 수 있다
		super("Checked Exception 발생");		
	}
	public MyChecked(String msg) {
		super(msg);
	}
}

class MyUnChecked extends RuntimeException{
	public MyUnChecked() {
//		printStactTrace(), getMeassage()를 통해 ㅁ세지를 전달 받을 수 있다
		super("UnChecked Exception 발생");		
	}
	public MyUnChecked(String msg) {
		super(msg);
	}
}

class MyUtil2{
	public static int mod(int i, int j) {
		if(j == 0) {
//			UnChecked라서 예외 처리하지 않아도 컴파일 오류가 발생하지 않는다
			throw new MyUnChecked("0으로 나눌수 없습니다");
		}
		else {
			return i/j;
		}
	}
	public static int div(int i, int j) throws MyChecked {
		if(j == 0) {
//			Checked라서 예외 처리하지 않아도 컴파일 오류가 발생한다
			throw new MyChecked("0으로 나눌수 없습니다");
		}
		else {
			return i/j;
		}
	}
}

public class ExcepTest5 {

	public static void main(String[] args) {
	

}
}