package Oop.day04;
//final的演示
public class FinalDemo {
	public static void main(String[] args) {
	}
}


final class Roo{}
//class Soo extends Roo{} //编译错误，final修饰的类不能被继承

class Too{}
final class Uoo extends Too{}



class Poo{
	final void show(){}
	void test(){}
}
class Qoo extends Poo{
	//void show(){} //编译错误，final修饰的方法不能被重写
	void test(){}
}


/*
 * final修饰成员变量，两种方式初始化:
 *  1)声明的同时初始化
 *  2)构造方法中初始化
 * final修饰局部变量，用之前初始化即可
 */
class Ooo{ //演示final修饰变量
	final int a = 5;
	final int b;
	Ooo(){
		b = 8;
	}

	void test(){
		final int c; //用之前给值即可
		//a = 55; //final修饰的变量不能被改变
	}
}














