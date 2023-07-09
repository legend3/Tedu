package Oop.day06;

//多态的演示
public class MulTypeDemo {
	public static void main(String[] args) {
		Aoo o1 = new Boo();//向上造型
//		o1.b();//1.2)同一个对象被造型为不同的类型时，有不同的功能(方法)，造型为Aoo
//		o1.b();可惜，只有Aoo的功能
		o1.X();//1.1)同一类型的引用被指向不同对象时，有不同功能(方法)的实现
		System.out.println("创建出的o1: " + o1);
		System.out.println("o1属于哪个类：" + o1.getClass());//Boo对象
		Boo o2 = (Boo) o1;//o1引用所指向的对象，就是该类型
		System.out.println("o2:" + o2);
		((Boo) o1).b();//1.2)同一个对象被造型为不同的类型时，有不同的功能(方法)，造型为Boo
		if(o1 instanceof Aoo){//判断一个对象是否为一个类的实例
			System.out.println("是否属于Aoo：True");//一个对象是否为一个类的实例，子类的对象必然是父类的实例
		}
		if(o1 instanceof Boo){//肯定是自己的对象实例!
			System.out.println("是否属于Boo：True");
		}
		System.out.println("o1：" + o1.getClass());
		System.out.println(o1 == o2);

		Inter1 o3 = (Inter1)o1;//o1引用所指向的对象，实现了该接口
		System.out.println("o1造型成Inter1接口后的类型：" + o1.getClass());
		System.out.println("o3属于什么类：" + o3.getClass());
		if(o1 instanceof Inter1){//是！
			System.out.println("是！");
		}
		try {
			Coo o4 = (Coo)o1; //类型转换异常: B未继承C，只是C继承了A；B、C都是A的子类！
			System.out.println("o1是什么类型：" + o1.getClass());
			if(o1 instanceof Coo){
				Coo o5 = (Coo)o1;
			}
		}catch (ClassCastException c){
			System.out.println("强转的引用指向对象不是此类型: " + c);
		}
	}
}

interface Inter1{
}

class Aoo{
	public void a() {
		System.out.println("a方法....");
	}
	public void X() {
		System.out.println("AOo的X");
	}
}

class Boo extends Aoo implements Inter1{//先继承后实现
	public void b() {
		System.out.println("b方法....");
	}
	public void X() {
		System.out.println("BOo的X");
	}
}

class Coo extends Aoo{
}
