package chapter05;

public class WrapperTest {

	public static void main(String[] args) {
		Integer iPrice = new Integer(5000);
		int price = iPrice.intValue();
		
//		java5부터
		Double IPI = 3.14;	//auto boxing
		double pi = IPI;
		
		Object inum = 256;
		
		/**
		 * 문자열 데이터를 해당 format의 Primitive
		 * parseXXX(String 값)
		 * - 잘못된 format으로 변경하면 NumberFormatExecption발생
		 */
		price = Integer.parseInt("5000");
		double rate = Double.parseDouble("0.1");
		
	}
}
