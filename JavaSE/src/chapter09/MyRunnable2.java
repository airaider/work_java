package chapter09;

class Count{
	private int i;
	public int inc() {
		if(i<=50) ++i; 
		return i;
	}
}
public class MyRunnable2 implements Runnable {
	private Count cnt = new Count();
	@Override
	public void run() {
		while(true) {
			synchronized (cnt) {
				int i = cnt.inc();
				System.out.println(Thread.currentThread().getName()+":"+i);
				if(i>=50) break;
			}
			try {Thread.sleep(10);}catch(Exception e) {}
		}
	}

}
