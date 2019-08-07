package chapter09;

public class ThreadTest2 {

	public static void main(String[] args) {
		MyThread t1 = new MyThread("t1");
		MyThread t2 = new MyThread("t2");
		MyThread t3 = new MyThread("t3");
		t1.setPriority(Thread.MIN_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("main end...");
	}

}
