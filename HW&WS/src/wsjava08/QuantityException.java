package wsjava08;

public class QuantityException extends Exception {
	public QuantityException() {
		super("수량이 부족합니다.");
	}
	public QuantityException(String msg) {
		super(msg);
	}
}
