package autowire;

public class Restaurant {
	private Waiter wt;
	
	public Restaurant() {
		System.out.println("Restaurant的无参构造器...");
	}

	//自动装配：构造器方式注入
	public Restaurant(Waiter wt) {
		System.out.println("Restaurant的有参构造器....");
	}

	public Waiter getWt() {
		return wt;
	}

	public void setWt(Waiter wt) {
		System.out.println("Restaurant的set方法...");
		this.wt = wt;
	}

	@Override
	public String toString() {
		return "Restaurant [wt=" + wt + "]";
	}
}
