package chapter04;

public class Account {
	private String no, password;
	protected int balance;
	public Account() {
		
	}
	public Account(String no, String password, int balance) {
		setNo(no);
		setPassword(password);
		setBalance(balance);
	}
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		if(balance>=0) {
			this.balance = balance;
		}else {
			System.err.println("잔액을 0원 이하로 설정할 수 없습니다.");
		}
		
	}
	
	/**
	 * 입금 기능
	 * @param amount 입금할 금액
	 * @return	입금후 잔액
	 */
	public int deposit(int amount) {
		return balance+=amount;
	}
	/**
	 * 출금 기능
	 * @param password 출금시 입력하는 비밀번호
	 * @param amount   출금할 금액
	 * @return   	       출금 후 잔액
	 */
	public int withdraw(String password, int amount) {
		if(password!=null && password.equals(this.password))
			if(balance>=amount) return balance-=amount;
			else System.out.println("잔액이 부족합니다!!!");
		else System.out.println("비밀 번호 오류!!!");
		return balance;
			
	}
	public String toString() {
		return "계좌번호:"+no+" 잔액:"+balance;
	}
	String show() {
		return "계좌번호:"+this.no+" 비밀번호:"+this.password+" 잔고:"+this.balance;
//		컴파일시에 자동적으로 this.를 붙여준다
	}
}
