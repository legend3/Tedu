package Oop.day06;

//成员内部类的演示
public class InnerClassDemo {
	public static void main(String[] args) {
		Mama m = new Mama();
//		m.createBaby().showMama();
		//Baby b = new Baby(); //编译错误，内部类对外不具备可见性

		//外部类创建内部类
		Mama.Baby baby01 = m.new Baby(2);//注意这种创建形式
		Mama.Baby baby02 = m.new Baby(5);//注意这种创建形式

		baby01.setName("baby01");
		baby02.setName("baby02");
		baby01.start();
		baby02.start();
		baby01.run();
		baby02.run();
	}
}

class Mama{ //外部类
	private String name;
	private int age = 30;
	private static String id;

	private Baby createBaby() {
		return new Baby(2); //内部类对象通常在外部类中创建
	}

	public void cook(){
		System.out.println("做饭");
	}
	public static void wash(){
		System.out.println("洗衣服");
	}

	public static void main(String[] args) {
		Mama m = new Mama();
		System.out.println(m.createBaby().age);//外部类调用内部类属性
		m.createBaby().showMama();//外部类调用内部类方法
	}

	//自我总结: 如何类中要频繁重复使用某一些属性、或方法且这些属性与方法与类属性间有调用关联，
	// 就把它们封装在一个成员内部类中，避免新建类、再调用！
	//多了一个功能更强大的baby属性
	class Baby extends Thread { //内部类
		private int age;//成员内部类自己的私有属性

		public Baby(int age) {
			this.age = age;
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + "通过内部类实现多继承...");
		}

		public String showMama(){
//			Mama.this.cook();//隐式调用外部类的非静态方法
			cook();//直接调用外部类的非静态方法
			Mama.wash();//调外部类静态方法
			name = "Baby`s name!";//1.可直接访问、修改外部类成员变量
			System.out.println("直接访问外部类成员变量：" + name);
			System.out.println("隐式的引用指向创建的它的外部类对象访问成员变量：" + Mama.this.name);//2.内部类有个隐式的引用指向了创建它的外部类对象
												//外部类名.this.
			//System.out.println(this.name); //编译错误，Baby类中不包含name
			System.out.println("外部类的age属性值：" + Mama.this.age);
			System.out.println("成员内部类的age属性值: " + this.age);
			System.out.println("成员内部类的age属性值: " + age);
			cook();
			wash();
			return name;
		}
	}
}
