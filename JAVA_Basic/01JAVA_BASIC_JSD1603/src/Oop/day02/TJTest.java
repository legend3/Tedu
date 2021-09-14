package Oop.day02;
//T型与J型的测试类
public class TJTest {
	public static void main(String[] args) {
		T t = new T(0,0);
		t.print();
		
		System.out.println("下落后:");
		t.drop();
		t.print();
		
		System.out.println("左移后:");
		t.moveLeft();
		t.print();
	}
}













