package hwjava10;

public class ProductNotFound extends Exception {
	public ProductNotFound() {
		super("해당 조건의 제품이 없습니다");
	}
	public ProductNotFound(String msg) {
		super(msg);
	}
	
}
