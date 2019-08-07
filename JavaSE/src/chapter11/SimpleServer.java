package chapter11;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
//			컴퓨터의 ip와 지정한 port를 이용해서 서버 구성
			ss = new ServerSocket(4321);
			System.out.println("SimpleServer start....");
			while(true) {
//				accept() : 클라이언트가 접속할 때까지 대기
//				클라이언트가 접속하면 통신할 수 있는 socket을 리턴
				Socket s = ss.accept();
				
				DataOutputStream dos = null;
				DataInputStream dis = null;
				try {
					dis = new DataInputStream(s.getInputStream());
					dos = new DataOutputStream(s.getOutputStream());
					System.out.println("클라이언트 ["+s.getInetAddress()+"]님 접속");
					String msg = dis.readUTF();
					System.out.println("전송 메세지:"+msg);
					dos.writeUTF(msg+"안녕하세요!! 서버 프로그래밍 쉽죠잉~");
					
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					IOUtil.close(dos);
					IOUtil.close(s);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			IOUtil.close(ss);
		}
	}
}
