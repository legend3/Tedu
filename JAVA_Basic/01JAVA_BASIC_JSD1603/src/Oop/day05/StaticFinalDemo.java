package Oop.day05;
//static final常量的演示
public class StaticFinalDemo {
	public static void main(String[] args) {

		System.out.println(Aoo.PI); //通过类名.来访问
		//Aoo.PI = 3.1415926; //编译错误，常量值不能被改变

		
		//加载Boo.class到方法区
		//type也存在方法区中
		//到方法区中获取type的值并输出
		System.out.println(Boo.type);
		
		//编译时被直接替换为具体的值，效率高
		//相当于System.out.println(250);
		System.out.println(Boo.NUM);
	}
}

class Boo{
	public static final int NUM = 250; //常量
	public static int type = 250; //静态变量
}

class Aoo{
	public static final double PI=3.1415926;
	//public static final int NUM; //编译错误，必须声明同时初始化
}
