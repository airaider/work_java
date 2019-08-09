package hwjava04;


public class ProductTest {

	public static void main(String[] args) {
		TV tv1 = new TV(123,"54인치",5400000,1,54,"ips");
		TV tv2 = new TV(488,"40인치",3200000,1,40,"led");
		Refrigerator rf = new Refrigerator(889,"가정용",1000000,1,30);
		
		System.out.println("*********************** TV목록 ***********************");
		System.out.println("제품번호\t|제품이름\t|가격\t\t|수량\t|인치\t|디스플레이 타입");
		System.out.println(tv1.toString());
		System.out.println(tv2.toString());
		System.out.println();
		System.out.println("********************** 냉장고목록 **********************");
		System.out.println("제품번호\t|제품이름\t|가격\t\t|수량\t|용량");
		System.out.println(rf.toString());
	}

}
