package hwjava07;

public class TV extends Product {
	private int inch;
	private String type;
	public TV() {
		
	}
	public TV(String no, String name, int price, int stock, int inch, String type) {
		super(no,name,price,stock);
		setInch(inch);
		this.type=type;
		
	}
	public int getInch() {
		return inch;
	}
	public void setInch(int inch) {
		if(inch>0)
		this.inch = inch;
		else System.out.println("0인치 이상으로 설정하세요.");
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+"\t|"+inch+"\t|"+type;
	}
	
	
}
