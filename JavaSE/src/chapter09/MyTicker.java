package chapter09;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyTicker extends Thread {
	private Frame frame;
	private Button startB, suspendB, resumeB, stateB, stopB, exitB;
	private Label msgL;
	private String msg = "Hello World SSAFY!!!!";
	private boolean isRun = true;
//	Anonymous Nested Class
	private ActionListener handler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource();	//event가 발생된 객체를 추출
			if(src == startB) {
				start();	//thread 동작 시키기
			}else if(src== suspendB) {
				suspend();	//thread 잠깐 중지 시키기
			}else if(src== resumeB) {
				resume();	//잠시 중지된 thread 다시 동작
			}else if(src== stopB) {
				stop();	//thread 완전 중지
//				isRun = false;
			}else if(src== exitB) {
				System.exit(0);
			}	//프로그램 종료
			System.out.println(getState()); //thread 상태 출력하기
			
		}
	};
	public MyTicker(ThreadGroup tg, String name) {
		super(tg, name);
		frame = new Frame("Thread Example");
		
		startB = new Button("startB");
		suspendB = new Button("suspendB");
		resumeB = new Button("resumeB");
		stateB = new Button("stateB");
		stopB = new Button("stopB");
		exitB = new Button("exitB");
		Panel south = new Panel();
		south.add(startB);
		south.add(suspendB);
		south.add(resumeB);
		south.add(stateB);
		south.add(stopB);
		south.add(exitB);
		startB.addActionListener(handler);
		suspendB.addActionListener(handler);
		resumeB.addActionListener(handler);
		stateB.addActionListener(handler);
		stopB.addActionListener(handler);
		exitB.addActionListener(handler);
		
		msgL = new Label(msg, Label.CENTER);
		frame.add(msgL, "Center");
		frame.add(south, "South");
		frame.setBounds(500, 500, 400, 200);
		frame.setVisible(true);
	}
	public void run() {
		while(isRun) {
			msg = msg.substring(1)+msg.charAt(0);
			msgL.setText(msg);
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		ThreadGroup tg, parent;
		tg = Thread.currentThread().getThreadGroup();
		parent = tg.getParent();
//		ThreadGroup을 생성할 때 부모 ThreadGroup를 지정하지 않으면
//		현재 코드를 동작시켜주는 쓰레드가 속한 ThreadGroup의 sub로 생성됨
		ThreadGroup mytg = new ThreadGroup(parent, "MyTG");
		new MyTicker(mytg, "t1").start();
//		main 쓰레드가 속한 ThreadGroup 추출
		
		parent.list();
		
		
		
//		for(tg = prent = Thread.currentThread().getThreadGroup();
//				prent!=null;
//				prent = tg.getParent());
//		tg.list();
		
	}
}
