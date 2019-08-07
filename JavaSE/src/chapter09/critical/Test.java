package chapter09.critical;

public class Test {
	public static void main(String[] args) {
		SyncStack stack = new SyncStack();
		
		Consumer c1 = new Consumer(stack, "c1");
		Consumer c2 = new Consumer(stack, "c2");
		Consumer c3 = new Consumer(stack, "c3");
		
		Producer p1 = new Producer(stack, "p1");
		Producer p2 = new Producer(stack, "p2");
		Producer p3 = new Producer(stack, "p3");
		
		c1.start();
		c2.start();
		c3.start();
		p1.start();
		p2.start();
		p3.start();
	}
}
