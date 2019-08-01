package chapter10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
> ObjectOutputStream
객체를 직렬화해서 출력
직렬화 : byte배열로 변환
+ 객체의 정보
+ 클래스명, 속성타입, 속성이름, 속성 값
Serializable 인터페이스를 구현한 클래스의 객체를 직렬화해서 출력
static, transient으로 선언된 속성은 출력에서 제외된다

> ObjectInputStream
byte배열을 읽어서 객체로 복원
static으로 건언된 속성은 객체를 복원하는 JVM에 설정된 static값으로 복원
transient으로 선언된 속성은 기본값으로 복원됨
 */


public class ObjectIO {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		FileInputStream fis = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		String file = "object.txt";
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(new Employee("1", "ssafy", 10000000));
			
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			System.out.println(ois.readObject());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			IOUtil.close(oos);
			IOUtil.close(fos);
			IOUtil.close(ois);
			IOUtil.close(fis);
		}
		
	}

}
