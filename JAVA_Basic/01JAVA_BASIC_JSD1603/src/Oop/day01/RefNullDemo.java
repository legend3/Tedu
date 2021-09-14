package Oop.day01;
//引用类型与null的演示
public class RefNullDemo {
	public static void main(String[] args) {
		Cell c = new Cell();
		Cell cc = c; //指向同一个对象
		c.row = 2;
		cc.row = 5;
		System.out.println("我是c的row:" + c.row); //5
		System.out.println("我是cc的row:" + cc.row); //5
		int a = 5;
		int b = a; //赋值
		b = 8;
		System.out.println(a); //5
		
		Cell ccc = new Cell();
		ccc.row = 2;
		ccc = null; //空，没有指向任何对象
		ccc.row = 5; //空指针异常NullPointerException
	}
}












