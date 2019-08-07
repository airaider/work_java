package chapter11;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SimpleClient2 {

	public static void main(String[] args) {
		Socket s = null;
		ObjectOutputStream oos = null;
		try {
			s = new Socket("70.12.108.80", 5432);
			oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(new Employee("91", "홍기환", 50000000));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			IOUtil.close(oos);
			IOUtil.close(s);
		}
		
	}

}
