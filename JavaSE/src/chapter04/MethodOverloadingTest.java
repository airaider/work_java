package chapter04;


class MyUtil{
	/**
	 * Method Overloading
	 * - 인자(인자의 개수, 인자의 타입, 인자의 순서)를 다르게 해서 동일한 이름의 함수를 여러개 선언
	 * - 인자를 통해 함수를 구별할 수 있다
	 * - 기능은 동일하지만 인자가 다른 경우 새로운 메소드를 건언해야 하는데
	 *   이때 동일한 이름의 매소드로 작성한다.
	 *   => 매소드를 호출할 때 인자에 따라 구별하지 않고 동일한 이름으로 호출한다
	 *   => 호출에 대한 편리성 제공
	 */
	public int plus(int a, int b) {
		return a+b;
	}
	public double plus(double a, double b) {
		return a+b;
	}
	public String plus(String a, String b) {
		return a+b;
	}
	
}
public class MethodOverloadingTest {
	public static void main(String[] args) {
		MyUtil util = new MyUtil();
		System.out.println(util.plus(256, 128));
		System.out.println(util.plus(256.5, 128.3));
		System.out.println(util.plus("256.5", "128.3"));
		

	}

}
