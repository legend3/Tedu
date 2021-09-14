package Oop.day06;

//多态的演示
public class MulTypeDemo {
	public static void main(String[] args) {
		Aoo o1 = new Boo(); //向上造型2.1)父类型的引用指向子类的对象
//		o1.b();可惜，只有Aoo的功能
		System.out.println("创建出的o1:" + o1);
		System.out.println(o1.getClass());//输出所属类
		Boo o2 = (Boo) o1; //3.1)引用所指向的对象，就是该类型
		System.out.println("o2:" + o2);
		((Boo) o1).b();//恢复真身！有了自己原本的功能
		if(o1 instanceof Aoo){//判断一个对象是否为一个类的实例
			System.out.println("是否属于Aoo：True");//一个对象是否为一个类的实例，子类的对象必然是父类的实例
		}
		if(o1 instanceof Boo){
			System.out.println("是否属于Boo：True");
		}
		System.out.println("强转后的o1:" + o1);
		System.out.println("o1被强转后是：" + o1.getClass());
		System.out.println(o1 == o2);

		Inter1 o3 = (Inter1)o1; //引用所指向对象Boo实现了Inter1接口
		System.out.println(o3.getClass());
		try {
			Coo o4 = (Coo)o1; //类型转换异常
			if(o1 instanceof Coo){
				Coo o5 = (Coo)o1;
			}
		}catch (ClassCastException c){
			System.out.println("强转的引用指向对象不是此类型:" + c);
		}
	}
}

interface Inter1{
}

class Aoo{
	public void a() {
		System.out.println("a方法....");
	}
}

class Boo extends Aoo implements Inter1{
	public void b() {
		System.out.println("b方法....");
	}
}

class Coo extends Aoo{
}
