package wsjava10;

public class ISBNNotFoundException extends Exception {
	public ISBNNotFoundException() {
		super("isbn을 검색할 수 없습니다.");
	}
	public ISBNNotFoundException(String msg) {
		super(msg);
	}
}
