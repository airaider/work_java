package hwjava10;

public class Refrigerator extends Product {
	private int liter;

	public Refrigerator() {
	}

	public Refrigerator(String no, String name, int price, int stock, int liter) {
		super(no, name, price, stock);
		setLiter(liter);
	}

	public int getLiter() {
		return liter;
	}

	public void setLiter(int liter) {
		if(liter>0) {
			this.liter = liter;
		}
		else {
			System.out.println("0리터 이상으로 책정하세요.");
		}
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Refrigerator [liter=").append(liter).append("]");
		return builder.toString()+super.toString();
	}
	
}
