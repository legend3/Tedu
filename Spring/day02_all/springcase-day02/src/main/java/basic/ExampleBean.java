package basic;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ExampleBean {
	private String name;
	private int age;
	private List<String> cities;
	private Set<String> interest;
	private Map<String,Double> score;
	private Properties db;
	public String getName() {
		return name;
	}

	public Properties getDb() {
		return db;
	}

	public void setDb(Properties db) {
		this.db = db;
	}

	public Map<String, Double> getScore() {
		return score;
	}

	public void setScore(Map<String, Double> score) {
		this.score = score;
	}

	public Set<String> getInterest() {
		return interest;
	}

	public void setInterest(Set<String> interest) {
		this.interest = interest;
	}

	public List<String> getCities() {
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ExampleBean() {
		System.out.println(
				"ExampleBean的无参构造器...");
	}

	@Override
	public String toString() {
		return "ExampleBean [name=" + name + ", age=" + age + ", cities=" + cities + ", interest=" + interest
				+ ", score=" + score + ", db=" + db + "]";
	}
	
	
	
}
