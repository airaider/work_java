package hwjava10;

public class DuplicateException extends Exception {
	public DuplicateException() {
		super("중복된 제품입니다.");
	}
	public DuplicateException(String msg) {
		super(msg);
	}
}
