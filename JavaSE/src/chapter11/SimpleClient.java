package chapter11;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class SimpleClient {

	public static void main(String[] args) {
		Socket s = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		try {
//			내부 네트워크를 통해 로컬 서버에 접속 : localhost, 127.0.0.1
			s = new Socket("70.12.108.80", 4321);
			dis = new DataInputStream(s.getInputStream());
			dos = new DataOutputStream(s.getOutputStream());
			dos.writeUTF("ㅇㅁㅇ!!");
			System.out.println("전송된 데이터: "+dis.readUTF());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			IOUtil.close(s);
		}
	}

}
