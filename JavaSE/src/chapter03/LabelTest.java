package chapter03;

public class LabelTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * label : loop문에 이름을 부여해서
		 * 		       중첩된 loop문에서 특정  loop를 break, continue할 수 있다.
		 */
		
		first:
			for (int i = 1; i <= 100; i++) {
				second:
					for(int j=1;j<=100;j++) {
						System.out.printf("%d * %d = %d ", i,j,i*j);
						if(i*j>50) {
							break first;
						}else if(i*j>30) {
							break;
						}
					}
				System.out.println();
				
			}

	}

}
