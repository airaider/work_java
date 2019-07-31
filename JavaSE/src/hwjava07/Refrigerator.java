package hwjava07;

public class Refrigerator extends Product {
	private int capacity;
	public Refrigerator() {
		
	}
	public Refrigerator(String no, String name, int price, int stock, int capacity) {
		super(no,name,price,stock);
		setCapacity(capacity);
		
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		if(capacity>0)
		this.capacity = capacity;
		else System.out.println("용량을 0L 이상으로 설정하세요.");
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+"\t|"+capacity;
	}
	
}
