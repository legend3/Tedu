package Basic.day06;
//方法的演示
public class MethodDemo {
	public static void main(String[] args) {
		say();
		say();//又被调用一次

//		sayHi(); //编译错误，有参则必须传参
//		sayHi(25); //编译错误，参数类型不匹配
		sayHi("zhangsan"); //String name="zhangsan"
		sayHi("lisi"); //String name="lisi"
		sayHi("wangwu"); //String name="wangwu"

		int a = getNum(); //getNum()的值就是return后的那个8
		System.out.println(a);

		double b = plus(5.5,6.6); //double num1=5.5,double num2=6.6
		System.out.println(b); //12.1

		double c=5.5,d=6.6;
		double e = plus(c,d); //double num1=5.5,double num2=6.6

		//方法的嵌套调用
		m1();
		System.out.println("over");
	}

	public static void m1(){
		System.out.println(111);
		m2();
		System.out.println(222);
	}
	public static void m2(){
		System.out.println(333);
	}

	//有参有返回值
	public static double plus(double num1,double num2){
		//double sum=num1+num2;
		//return sum; //返回的是sum里面的那个数

		return num1+num2;
	}

	//无参有返回值
	public static int getNum(){
		//return; //编译错误，必须返回一个值
		//return 8.88; //编译错误，返回值类型不匹配
		return 8; //1.终止方法的执行  2.返回结果给调用方
	}

//	有参无返回值
	public static void sayHi(String name){
		System.out.println("大家好，我叫" + name);
		return; //1)结束方法的执行
	}

	//无参无返回值
	public static void say(){
		System.out.println("大家好，我叫WKJ");
	}
}
