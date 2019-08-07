package chapter09;

public class MyThread extends Thread {
	private int i;
	public MyThread(String name) {
		super(name);	//Thread 이름 설정, 이름을 설정하지 않으면 Thread-0번 부터 차례로 부여됨
	}
	@Override
	public void run() {
		for (i = 1; i <= 50; i++) {
//			Thread.currentThread() : 현재 코드를 수행하는 Thread를 수행
			System.out.println(Thread.currentThread().getName()+":"+i);
			try {
				sleep(100);
			}catch(Exception e) {
				
			}
		}
	}
}
