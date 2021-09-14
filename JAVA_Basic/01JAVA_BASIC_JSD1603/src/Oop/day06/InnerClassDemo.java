package Oop.day06;

//内部类的演示
public class InnerClassDemo {
	public static void main(String[] args) {
		Mama m = new Mama();
		m.createBaby().showMamaName();
		//Baby b = new Baby(); //编译错误，内部类对外不具备可见性
	}
}

class Mama{ //外部类
	private String name;

	Baby createBaby(){
		return new Baby(10); //内部类对象通常在外部类中创建
	}

	public static void main(String[] args) {
		Mama m = new Mama();
		System.out.println(m.createBaby().age);//外部类调用内部类属性
		m.createBaby().showMamaName();//外部类调用内部类方法
	}

	class Baby{ //内部类
		private int age;

		public Baby(int age) {
			this.age = age;
		}

		public String showMamaName(){
			name = "Baby`s name!";//1.可直接访问外部类成员变量
			System.out.println("直接访问外部类成员变量：" + name);
			System.out.println("隐式的引用指向创建的它的外部类对象访问成员变量：" + Mama.this.name);//2.内部类有个隐式的引用指向了创建它的外部类对象
												// 外部类名.this.
			//System.out.println(this.name); //编译错误，Baby类中不包含name
			return name;
		}
	}
}