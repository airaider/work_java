package chapter03;

public class CastTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b1=10, b2=30;
		int i1 = b1+b2;
		byte b3 = (byte)(b1+b2);
		
		char a='a';
		int i2 = a;
		System.out.println(i2);
		

		int i3 = a+1;
		System.out.println((char)(i3));
		
		long l1=i2;
		long l2 = 22222222222l;
		float f1 = l2;
		System.out.println(f1);
		double d1 = f1;
		
//		boolean bl1 = d1;		//논리는 형변환이 안됨
		boolean bl2 = true;
//		int i4 = (int) bl2;
		
	}

}
