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
		if (this.getClass() != otherObj.getClass())  //测试两个对象所属的类(getClass()代表引用指向的对象<new xxx()>))是否相同，否则返回false
			return false;
		//instanceof: 左边是对象，右边是类；当左边对象是右边类或子类所创建对象时，返回true；否则，返回false。
		if (otherObj instanceof Key) {	//再判断是不是Key类(或Key子类)的实例,提高代码的健壮性
			Key other = (Key) otherObj;    //对otherObject进行类型转换以便和类Key的对象进行比较
			return other.getAge()==this.getAge() && other.getSex()==this.getSex();//比较
		}
		return true;
	}

	//如果一个类是不变类，并且计算hashCode码的开销也比较大，那么可以考虑将hashCode码缓存在对象内部，计算一次享用终生，而不是每次请求的时候都重新计算散列码
	private volatile int hashCode;
	@Override
	public int hashCode() {
//		int result = 17;
		int result = hashCode;
		if(result == 0) {
			result = Integer.hashCode(age);//首个field
//			result = 31 * result + age;
			result = 31 * result + (sex == null ? 0 : sex.hashCode());
			//System.out.println(result);
			hashCode = result;//把散列码缓存在对象内部
		}
		return result;
	}

	@Override
	public String toString() {
		return "Key: {" +
				"age:" + this.age +
				", sex:'" + this.sex + '\'' +
				'}';
	}
}
