package chapter09;

public class RunnableTest2 {

	public static void main(String[] args) {
		MyRunnable2 work = new MyRunnable2();
		Thread t1 = new Thread(work, "t1");
		Thread t2 = new Thread(work, "t2");
		Thread t3 = new Thread(work, "t3");
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("main end");
	}

}
