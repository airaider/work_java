package chapter08;


public class ExcepTest3 {

	public static void main(String[] args) {
		int result = 0;
		try {
			result = 256/Integer.parseInt(args[0]);	
//		}catch(ArrayIndexOutOfBoundsException e){
//			System.out.println("처리할 데이터를 입력해주세요");
		}catch(ArithmeticException e) {
			System.out.println("0이 아닌 정수를 입력해주세요");
			return;
		}
		catch(NumberFormatException e) {
			System.out.println("정수를 입력해주세요");
			System.exit(0);
		}
		finally{
			/**
			 * finally문은 try문이 수행되면 반드시 수행되는 문장
			 * - 반드시 처리해야 하는 기능을 작성 ex) 자원반납
			 * - finally문이 수행되는 경우
			 * 	> 어류가 발생하지 않아도 수행됨
			 * 	> 오류가 발생해도 수행됨
			 * 	> 오류가 발생했지만 처리되지 않은 경우에도 수행됨
			 *  > try문이나 catch문에서 return된 경우에도 수행됨
			 * - finally문이 수행되지 않는 경우
			 *  > System.exit(~)을 통해 JVM을 종료시킨 경우
			 */
			System.out.println("finally문이 수행됨");
		}
		
		System.out.println("수행 결과 :"+result);
	}

}
