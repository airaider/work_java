package chapter08;


public class ExcepTest2 {

	public static void main(String[] args) {
		int result = 0;
		try {
			result = 256/Integer.parseInt(args[0]);	
		}
			//		}catch(Exception e) {
////			다양한 오류
//			System.out.println("0이 아닌 정수를 입력해주세요");
//		}
		
//		오류 마다 처리 방법이 다른경우 각각 처리한다
			catch(ArrayIndexOutOfBoundsException e){
			System.out.println("처리할 데이터를 입력해주세요");
		}catch(ArithmeticException e) {
			System.out.println("0이 아닌 정수를 입력해주세요");
		}
		catch(NumberFormatException e) {
			System.out.println("정수를 입력해주세요");
		}
		System.out.println("수행 결과 :"+result);
	}

}
