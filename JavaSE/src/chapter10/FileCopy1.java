package chapter10;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy1 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		String readFile = "C:/SSAFY/eclipse.zip";
		String writeFile = "res/copy.zip";
		try {
			fis = new FileInputStream(readFile);
			fos = new FileOutputStream(writeFile);
			int read;
			byte[] buf = new byte[8192];
			while((read = fis.read())!=-1) {
				fos.write(buf, 0, read);
			}
			System.out.println("read done");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(fis!=null) try {fis.close();} catch(Exception e) {}
			if(fis!=null) try {fis.close();} catch(Exception e) {}
		}

	}

}
