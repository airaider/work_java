package hwjava04;

public class Refrigerator {
	private int num;
	private String name;
	private int price;
	private int cnt;
	private int capacity;
	public Refrigerator() {
		
	}
	public Refrigerator(int num, String name, int price, int cnt, int capacity) {
		this.num = num;
		this.name = name;
		setPrice(price);
		setCnt(cnt);
		setCapacity(capacity);
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price>=0) this.price = price;
		else System.out.println("냉장고 가격은 0원 이상으로 설정하세요");
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		if(cnt>=0) this.cnt = cnt;
		else System.out.println("냉장고 개수는 0개 이상으로 설정하세요");
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		if(capacity>=0) this.capacity = capacity;
		else System.out.println("냉장고 용량은 0 이상으로 설정하세요");
	}
	public String toString() {
		return num+"\t|"+name+"\t|"+price+"\t|"+cnt+"\t|"+capacity;
	}
	
	
}
