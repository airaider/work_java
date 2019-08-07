package chapter09;

public class ThreadTest1 {

	public static void main(String[] args) {
		MyThread t1 = new MyThread("t1");
		MyThread t2 = new MyThread("t2");
		MyThread t3 = new MyThread("t3");
		
		t1.start();
		t2.start();
		t3.start();
		
//		t1.run();
//		t2.run();
//		t3.run();
		
		System.out.println("main end...");
	}

}
