package Oop.day03;
//向上造型的演示
public class UpDemo {
	public static void main(String[] args) {
		Eoo o1 = new Eoo();
		o1.a = 1;
		o1.show();
		//o1.b = 2; //编译错误，父不能访问子的
		
		Foo o2 = new Foo();
		o2.b = 1;
		o2.test();
		o2.a = 2;
		o2.show(); //子可以访问父的
		
		Eoo o3 = new Foo();
		o3.a = 1;
		o3.show();
//		o3.b = 2; //编译错误，能点出来什么，看引用的类型--（Eoo）
	}
}

class Eoo{
	int a;
	void show(){}
}
class Foo extends Eoo{
	int b;
	void test(){}
}
