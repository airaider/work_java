package chapter09;

public class RunnableTest1 {

	public static void main(String[] args) {
		MyRunnable work = new MyRunnable();
		Thread t1 = new Thread(work, "t1");
		Thread t2 = new Thread(work, "t2");
		Thread t3 = new Thread(work, "t3");
		
		t1.start();
		t2.start();
		t3.start();
//		t1.run();
//		t2.run();
//		t3.run();
		
		System.out.println("main end");
	}

}
