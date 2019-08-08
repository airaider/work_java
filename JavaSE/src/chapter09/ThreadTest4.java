package chapter09;

public class ThreadTest4 {

	public static void main(String[] args) {
		MyThread t1 = new MyThread("t1");
		
//		daemon 쓰레드 :  master thread가 종료되면 같이 종료되는 쓰레드
//		Master Thread : setDaemon(~)를 수행시켜주는 쓰레드
		t1.setDaemon(true);
		t1.start();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("main end...");
	}

}
