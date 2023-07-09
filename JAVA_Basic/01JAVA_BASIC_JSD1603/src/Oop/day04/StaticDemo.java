package Oop.day04;
//static的演示

public class StaticDemo {
	public static void main(String[] args) {
		Loo o1 = new Loo();
		o1.show();
		Loo o2 = new Loo();
		o2.show();
		System.out.println(Loo.b); //建议类名.来访问
		System.out.println(o1.b); //不建议
		
		Moo.test();
		new Moo().test();//实例也可以的！
//
		Noo o3 = new Noo();
		Noo o4 = new Noo();
	}
}

class Noo{
	static{
		System.out.println("静态块");
	}
	Noo(){
		System.out.println("构造方法");
	}
}

class Moo{
	/**
	* Description: 演示静态方法
	* @param: null
	* @return:
	* @author: LEGEND
	* @Date: 2023/7/9 14:53
	*/
	int a; //实例变量
	static int b; //静态变量
	void show(){ //实例方法--有隐式的this
		a = 1;
		b = 2;
	}
	static void test(){ //静态方法--没有隐式的this
		//a = 1; //编译错误，没有this即没有对象，所以不能直接访问实例成员
		new Moo().a = 1;
		b = 2;
		System.out.println("test调用成功！");
	}
}

class Loo{
	/**
	* Description: 静态变量
	* @param: null
	* @return:
	* @author: LEGEND
	* @Date: 2023/7/9 14:53
	*/
	int a;
	static int b;
	Loo(){
		a++;
		b++;
	}
	void show(){
		System.out.println("a="+a);
		System.out.println("b="+b);
	}
}
