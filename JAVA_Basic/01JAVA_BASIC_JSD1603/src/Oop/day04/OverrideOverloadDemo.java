package Oop.day04;
//重载与重写的区别
public class OverrideOverloadDemo {
	public static void main(String[] args) {
		//重写看对象，重载看引用

		/*
		Goo goo = new Goo();
		Eoo o = new Eoo();
		goo.test(o);
		*/
		/*
		Goo goo = new Goo();
		Foo o = new Foo();
		goo.test(o);
		*/

		Goo goo = new Goo();
		Eoo o = new Foo(); //向上造型
		goo.test(o);
	}
}

class Goo{
	// 重载
	void test(Eoo o){
		System.out.println("父型参数");
		o.show();
	}
	void test(Foo o){
		System.out.println("子型参数");
		o.show();
	}
}
class Eoo{
	void show(){
		System.out.println("父类show");
	}
}
class Foo extends Eoo{
	//重写
	void show(){
		System.out.println("子类show");
	}
}


