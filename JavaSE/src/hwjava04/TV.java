package hwjava04;

public class TV {
	private int num;
	private String name;
	private int price;
	private int cnt;
	private int inch;
	private String type;
	public TV() {
		
	}
	public TV(int num, String name, int price, int cnt, int inch, String type) {
		this.num = num;
		this.name = name;
		setPrice(price);
		setCnt(cnt);
		setInch(inch);
		this.type = type;
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
		else System.out.println("TV 가격은 0원 이상으로 설정하세요");
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		if(cnt>=0) this.cnt = cnt;
		else System.out.println("TV 개수는 0개 이상으로 설정하세요");
	}
	public int getInch() {
		return inch;
	}
	public void setInch(int inch) {
		if(inch>=0) this.inch = inch;
		else System.out.println("TV 인치는 0인치 이상으로 설정하세요");
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String toString() {
		return num+"\t|"+name+"\t|"+price+"\t|"+cnt+"\t|"+inch+"\t|"+type;
	}
	
	
}
