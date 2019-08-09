package hwjava10;

public class TV extends Product {
	private int inch;

	public TV() {
	}

	public TV(String no, String name, int price, int stock, int inch) {
		super(no, name, price, stock);
		setInch(inch);
	}

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		if(inch>0) {
			this.inch = inch;
		}
		else {
			System.out.println("인치를 0이상으로 설정하세요.");
		}
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TV [inch=").append(inch).append("]");
		return builder.toString()+super.toString();
	}

}
