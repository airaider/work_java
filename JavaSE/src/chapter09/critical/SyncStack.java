package chapter09.critical;

import java.util.ArrayList;

//데이터가 없으면 wait()를 통해 thread를 멈추고
//데이터가 추가 되면 notify()
public class SyncStack {
	private ArrayList<Character> stack;
	private Thread t;
	public SyncStack() {
		stack = new ArrayList<>(100);
	}
	public void push(char data) {
		this.notify();
		stack.add(data);	//맨끝에 추가
	}public char pop() {
		char data = ' ';
		while(stack.size()<=0) {
			try{wait();}catch(InterruptedException i) {}
		}
		data = stack.remove(stack.size()-1);
		return data;
	}
	@Override
	public synchronized String toString() {
		return stack.toString();
	}
	
}

////데이터가 없으면 suspend를 통해 Thread를 멈추고
////데이터가 추가 되면 resume
//동기화된 상태에서 suspend를 해서 DeadLock이 됨
//public class SyncStack {
//	private ArrayList<Character> stack;
//	private Thread t;
//	public SyncStack() {
//		stack = new ArrayList<>(100);
//	}
//	public void push(char data) {
//		stack.add(data);	//맨끝에 추가
//		t.resume();
//	}public char pop() {
//		char data = ' ';
//		try {
//			if(stack.size()<=0) {
//				t= Thread.currentThread();
//				t.suspend();
//			}
//			data = stack.remove(stack.size()-1);
//		} catch (ArrayIndexOutOfBoundsException e) {
//			e.printStackTrace();
//		}
//		return data;
//	}
//	@Override
//	public synchronized String toString() {
//		return stack.toString();
//	}
//	
//}
//
//데이터가 없는데 삭제를 하면 ArrayIndexOutOfBoundsException 발생
//
//public class SyncStack {
//	private ArrayList<Character> stack;
//	public SyncStack() {
//		stack = new ArrayList<>(100);
//	}
//	public void push(char data) {
//		stack.add(data);	//맨끝에 추가
//	}public char pop() {
//		char data = ' ';
//		try {
//			data = stack.remove(stack.size()-1);
//		} catch (ArrayIndexOutOfBoundsException e) {
//			e.printStackTrace();
//		}
//		return data;
//	}
//	@Override
//	public synchronized String toString() {
//		return stack.toString();
//	}
//	
//}
//
