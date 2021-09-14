package entity;

public class Emp2 {
	private Integer empNo;
	private String eName;
	private Integer age;
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Emp2 [empNo=" + empNo + ", eName=" + eName + ", age=" + age + "]";
	}
}
