package Oop.day05;

//接口的演示
public class InterfaceDemo {
	public static void main(String[] args) {
		//Inter5 o1 = new Inter5(); //编译错误，接口不能被实例化
		Inter6 o2 = new Foo(); //向上造型
		Inter5 o3 = new Foo(); //向上造型

		/*
		 * 接口的练习:
		 * 1.声明接口Inter1，包含常量PI和show()
		 * 2.声明接口Inter2，包含a()和b()
		 *   声明类Aoo，实现Inter2
		 * 3.声明接口Inter3，包含c()
		 *   声明类Boo，实现Inter2和Inter3
		 * 4.声明抽象类Coo，包含抽象方法d()
		 *   声明类Doo，继承Coo并实现Inter2和Inter3
		 * 5.声明接口Inter4，继承Inter2
		 *   声明类Eoo，实现Inter4
		 * 6.main方法中:
		 *    Inter4 o4 = new Inter4();------不能实例化
		 *    Inter4 o5 = new Eoo();---------Eoo实现了Inter4，可以实例化
		 *    Inter2 o6 = new Eoo();---------???
		 *
		 */
//		Inter2 o6 = (Inter2) new Eoo();
	}
}
//演示接口的继承
interface Inter5 {
	void a();
}
interface Inter6 extends Inter5{//接口继承接口
	void b();
}
class Foo implements Inter6 {//两个都要实现
	public void b(){}
	public void a(){}
}

//演示先继承后实现
interface Inter3 {
	public static final int NUM = 250; //常量
	void a();
	void b();
}
interface Inter4 {
	void c();
}
abstract class Doo {
	abstract void d();
}
class Eoo extends Doo implements Inter3, Inter4{
	public void a(){}
	public void b(){}
	public void c(){}
	void d(){}
}

//演示接口的实现
interface Inter2{
	void a();
	void b();
}
class Coo implements Inter2{
	public void a(){
		System.out.println("实现接口Inter2的a()");
	}
	public void b(){
		System.out.println("实现接口Inter2的b()");
	}
}

//演示接口的语法
interface Inter1{
	public static final int NUM = 250; //常量
	public abstract void show(); //抽象方法
	
	double PI=3.14159; //默认public static final
	void test(); //默认public abstract
	
	//int a; //编译错误，a默认为常量，但未初始化
	//void say(){} //编译错误，只能包含抽象方法
}