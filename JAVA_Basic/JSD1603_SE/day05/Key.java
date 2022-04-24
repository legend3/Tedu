package day05;

import java.util.ArrayList;

public class Key {
	private int age;
	private String sex;
	private boolean bo;
	private byte by;//char、shot
	private long l;
	private float f;
	private double d;
	private ArrayList arrayList;
	private Point P;

	public Key(int age, String sex) {
		this.age = age;
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + age;
		result = 31 * result + (sex == null ? 0 : sex.hashCode());
//		System.out.println(result);
		return result;
	}

	/**
	 * 使用==操作符检查“参数是否为这个对象的引用”；
	 * 使用instanceof操作符检查“参数是否为正确的类型”；
	 * 对于类中的关键属性，检查参数传入对象的属性是否与之相匹配；
	 * 编写完equals方法后，问自己它是否满足对称性、传递性、一致性；
	 * @param otherObj
	 * @return
	 */
	@Override
	public boolean equals(Object otherObj) {//不被重写（原生）的equals方法是严格判断一个对象是否相等的方法（object1 == object2）。
		if (this == otherObj) //
			return true;
		if (otherObj == null) //测试检测的对象是否为空，是就返回false
			return false;
		if (this.getClass() != otherObj.getClass())  //测试两个对象所属的类是否相同，否则返回false
			return false;
		if (otherObj instanceof Key) {	//再判断是不是Key类,提高代码的健壮性
			Key other = (Key) otherObj;    //对otherObject进行类型转换以便和类Key的对象进行比较
			return other.getAge()==this.getAge() && other.getSex()==this.getSex();//比较
		}
		return true;
	}

	@Override
	public String toString() {
		return "Key: {" +
				"age:" + this.age +
				", sex:'" + this.sex + '\'' +
				'}';
	}
}
