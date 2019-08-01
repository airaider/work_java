package chapter10;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 자바 데이터 타입(Primitive, String)을 유지하며 입출력
 * 주의점
 * 출력한 순서대로 데이터를 입력 받아야 한다
 */

public class DataIO {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		FileInputStream fis = null;
		DataOutputStream dos = null;
		DataInputStream dis = null;
		
		String file = "data.txt";
		try {
			fos = new FileOutputStream(file);
			dos = new DataOutputStream(fos);
			
			dos.writeLong(256);
			dos.writeDouble(3.14);
			dos.writeUTF("hello world");
			dos.writeBoolean(true);
			fis = new FileInputStream(file);
			dis = new DataInputStream(fis);
			System.out.println(dis.readLong());
			System.out.println(dis.readDouble());
			System.out.println(dis.readUTF());
			System.out.println(dis.readBoolean());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			IOUtil.close(dis);
			IOUtil.close(fis);
			IOUtil.close(dos);
			IOUtil.close(fos);
		}
	}

}
