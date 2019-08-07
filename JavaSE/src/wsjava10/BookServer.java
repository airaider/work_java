package wsjava10;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import hwjava10.Product;
class UserService extends Thread{
	private Socket socket;
	public UserService(Socket socket) {
		this.socket = socket;
	}
	public void run() {
		FileOutputStream   fos = null;
		ObjectOutputStream oos = null;
		ObjectInputStream  ois = null;
		try {
			String fileName = String.format("Books%s.txt"
					,socket.getInetAddress().toString().substring(1));
			//네트웍으로 부터 데이타 전송 받을 스트림
			ois = new ObjectInputStream(socket.getInputStream());
			fos = new FileOutputStream(fileName);
			//파일에 출력할 스트림
			oos = new ObjectOutputStream(fos);
			//네트웍으로 부터 입력 받은 데이타를 바로 출력
			Object result = ois.readObject();
			List<Book> temp = (List<Book>) result;
			for (Book product : temp) {
				System.out.println(product);
			}
			oos.writeObject(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtil.close(oos);
			IOUtil.close(fos);
			IOUtil.close(ois);
			IOUtil.close(socket);
		}
	}
}
public class BookServer {
	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(5433);
			System.out.println("BookServer start.....");
			while(true) {
				Socket s = ss.accept();
				System.out.println("클라이언트 "+s.getInetAddress()+"접속");
				new UserService(s).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtil.close(ss);
		}
	}
}







