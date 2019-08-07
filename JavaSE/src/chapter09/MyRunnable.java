package chapter09;

public class MyRunnable implements Runnable {
	private int i;
	@Override
	public synchronized void run() {
		for (i = 1; i <= 50; i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
			try {Thread.sleep(50);}catch(Exception e) {}
		}
	}

}
