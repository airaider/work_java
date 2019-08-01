package chapter10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Reader/Writer
 * - 문자 전용 입출력 API
 * - 문자가 아닌 데이터를 입출력하면 데이터가 손상된다 
 *
 */

public class FileCopy3 {

	public static void main(String[] args) {
		FileReader fis = null;
		FileWriter fos = null;
		String readFile = "src/chapter10/FileCopy1.java";
		String writeFile = "res/copy3.txt";
		try {
			fis = new FileReader(readFile);
			fos = new FileWriter(writeFile);
			int read;
			char[] buf = new char[8192];
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
