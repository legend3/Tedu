package Oop.day05;

//求一组图形的最大面积
public class ShapeTest {
	public static void maxArea(Shape[] shapes){//静态方法，选出数组中面积最大的元素
		double max = shapes[0].area();
		int maxIndex = 0; //最大面积下标
		for(int i=1;i<shapes.length;i++){
			double area = shapes[i].area();
			if(area>max){
				max=area;
				maxIndex=i;
			}
		}
		System.out.println("最大面积为:"+max+"，所在索引为:"+maxIndex);
	}
	public static void main(String[] args) {
		//Shape s = new Shape(); //编译错误，抽象类不能被实例化
		Shape.a();
		Shape[] shapes = new Shape[4]; //创建Shape数组对象
		shapes[0] = new Circle(1);
		shapes[1] = new Circle(2);
		shapes[2] = new Square(1);
		shapes[3] = new Square(2);
		maxArea(shapes);

		B b = new B();
		System.out.println(b.area());
	}
}

abstract class Shape{ //抽象类
	protected double c; //周长

	public abstract double area();//抽象方法（不含抽象方法也可以是一个抽象类）

	//普通静态方法
	public static void a() {
		System.out.println("调用抽象类中的非抽象方法a()！");
	}
}

class Circle extends Shape { //方:0.0625
	public Circle(double c) {
		this.c = c;
	}

	@Override
	public double area(){ //重写抽象方法
		return 0.0796*c*c;
	}
}

class Square extends Shape {
	public Square(double c){
		this.c = c;
	}
	@Override
	public double area() { //重写抽象方法
		return 0.0625*c*c;
	}
}

abstract class A extends Shape {//不实现继承抽象类的方法的类只能是抽象类
	void nothing() {
		System.out.println("抽象类的中不抽象方法");
	}
}

class B extends A {
	@Override
	public double area() {
		System.out.println("继承A后实现Shape的抽象方法");
		return 0;
	}
}
