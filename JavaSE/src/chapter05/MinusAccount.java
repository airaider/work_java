package chapter05;

import chapter04.Account;

public class MinusAccount extends Account{
	private int limit;
	public MinusAccount() {
		
	}
	public MinusAccount(String no, String password, int balance, int limit) {

		super(no,password,balance);
		this.limit=limit;
	}
	
	
	public String toString(){
		return super.toString()+" 한도:"+limit;
	}
	public void setBalance(int balance) {
		if(balance - limit>=0) {
			this.balance = balance;
		}else {
			System.out.println("마이너스 한도 미만으로 설정할 수 없습니다.");
		}
	}
	public int withdraw(String password, int amount) {
		if(password!=null && password.equals(getPassword()))
			if(this.balance>=amount-limit) balance-=amount;
			else System.out.println("출금 금액이 마이너스한도를 넘어서 출금할 수 없습니다.");
		else System.out.println("비밀 번호 오류!!!");
		return balance;
			
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}

}
