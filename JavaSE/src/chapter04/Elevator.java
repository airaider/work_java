package chapter04;
/**
 * current	int		현재층
 * max		int		최고층
 * min		int		최저층
 * isOpen	boolean	문이 열렸는지 닫혔는지
 * request	int		요청층	
 * move()			엘리베이터가 이동
 * close()			엘리베이터 문이 닫힘
 * open()			엘리베이터 문이 열림
 * choose(floor:int)사용자가 이동할 층을 선택하는 기능
 * 
 */
public class Elevator {
	private int current,max,min;
	private boolean isOpen;
	/**사용자가 요청한 층*/
	public int request;
	public Elevator() {
		current = 1;
		max = 3;
		min = 1;
	}
	
	public Elevator(int current, int max, int min, boolean isOpen) {
		this.max = max;
		this.min = min;
		this.isOpen = isOpen;
		setCurrent(current);
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		if(current>=min && current<=max)
			this.current = current;
		else System.out.println("잘못된 층을 설정했습니다.");
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public int getRequest() {
		return request;
	}

	public void setRequest(int request) {
		if(request>min && request<max)
			this.request = request;
		else System.out.println("잘못된 층을 설정했습니다.");
	}

	public void move() {
		if(isOpen) {
			close();
		}
		String msg="올라가고";
		while(true) {
			if(current < request) {
				current++;
			}
			else if(current>request) {
				current--;
				msg="내려가고";
			}
			else {
				System.out.printf("%d층에 도착했습니다!\n", request);
				break;
			}
			if(current==0) {
				continue;
			}
			System.out.printf("%d층으로 %s 있습니다\n", current, msg);
		}
		open();
	}
	
	public void close() {
		setOpen(false);
		System.out.println("문이 닫힙니다");
	}
	public void open() {
		setOpen(true);
		System.out.println("문이 열립니다");
	}
	public void choose(int floor) {
		setRequest(floor);
		
		if(getCurrent()==floor) {
			System.out.println("요청한 층은 현재층이므로 움직일 수 없습니다.");
			return;
		}
		else if(floor > getMax() || floor < getMin()) {
			System.out.println("요청한 층은 잘못된층이므로 움직일 수 없습니다.");
			return;
		}
		else {
			request = floor;
			move();
		}
	}
	public String toString() {
		return current+"현재층 "+max+"최상층 "+min+"최하층 "+isOpen+"문";
	}
}
