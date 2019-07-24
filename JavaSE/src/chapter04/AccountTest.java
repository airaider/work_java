package chapter04;

public class AccountTest {

	public static void main(String[] args) {
//		Account  user1;
//		user1=new Account();
//		System.out.println(user1.show());
//		user1.no="123-456";
//		user1.password="123";
//		user1.balance=10000;
//		System.out.println(user1.show());
//		
//		user1.deposit(5000);
//		System.out.println(user1.show());
//		user1.withdraw("123", 7000);
//		System.out.println(user1.show());
//		user1.withdraw("124", 7000);
//		System.out.println(user1.show());
		
		Account user2=new Account("987-654","000",-5555);
		System.out.println("입금 후 잔액 : "+user2.deposit(10000));
		System.out.println("출금 후 잔액 : "+user2.withdraw("001",20000));
		System.out.println("출금 후 잔액 : "+user2.withdraw("000",20000));
		System.out.println("출금 후 잔액 : "+user2.withdraw("000",10000));
	}

}
