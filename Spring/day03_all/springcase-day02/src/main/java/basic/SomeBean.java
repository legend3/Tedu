package basic;

public class SomeBean {
	private String name;
	private String city;
	private double score;
	private int pageSize;
	
	public SomeBean() {
		System.out.println("SomeBean的无参构造器...");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "SomeBean [name=" + name + ", city=" + city + ", score=" + score + ", pageSize=" + pageSize + "]";
	}
}
