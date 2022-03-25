package Oop.day06;

//匿名内部类的演示
public class NstInnerClassDemo {

	public static void main(String[] args) {
		//1.实现了某接口的匿名内部类
		//1.创建了Inter2的子类，没有名字
		//2.为该子类创建了一个对象，叫o1
		//3.大括号中的为子类的类体
		Inter2 o1 = new Inter2(){
		};

		//1.创建了Inter2的子类，没有名字
		//2.为该子类创建了一个对象，叫o2
		//3.大括号中的为子类的类体
		new Inter2(){
			public void hi(){
				System.out.println("匿名内部类");
			}
		};

//		final int num = 5;
		int num = 5;//被匿名内部类调用时会自动追加final

		//1.创建Inter3的一个子类，没有名字
		//2.为该子类创建了一个对象，名为o3
		//3.大括号中的为子类的类体
		Inter3 o3 = new Inter3(){
			@Override
			public void show(){
				System.out.println("showshow");
//				num = 6;
				System.out.println(num);//Java 8更加智能：如果局部变量被匿名内部类访问，
											// 那么该局部变量相当于自动使用了final修饰。
										//因此，匿名类中只能调用final变量
			}
		};
		o3.show();

		//2.继承某类方式
		Come c = new Come(){//继承Come，重写c4的方法
			@Override
			public void c4() {
				System.out.println("C4匿名内部类重写c4方法");
			}
//			public void c6() {
//				System.out.println("C4匿名内部类c6");
//			}
		};
		c.c4();
		System.out.println(c.getClass().getName());//class Oop.day06.NstInnerClassDemo$4	第四个匿名类
		if(c instanceof Come){
			System.out.println("True");
		}
//		c4.c6();//因为匿名内部类是继承C4类，因此只有C的功能

		C5 c5 = new C5();
		c5.c4();
		c5.c5();

		//匿名内部类的使用场景:当类或接口类型作为参数传递时，可以直接使用匿名内部类方式创建对应的对象
		test(new Inter4() {
			public void show(){
				System.out.println("Inter4的匿名内部类重写show()方法.");
			}
		});
	}

		public static void test(Inter4 i) {//Inter4的实例对象作为参数
			i.show();
		}
}

interface Inter3{
	void show();
}

interface Inter2{
	
}

class Come {
	public void c4() {
		System.out.println("c4方法......");
	}
}

class C5 extends Come {
	public void c5() {
		System.out.println("c5方法......");
	}
}

interface Inter4{
	void show();
}