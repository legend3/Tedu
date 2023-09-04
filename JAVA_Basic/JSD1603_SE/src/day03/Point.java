package day03;
/**
 * 用该类来测试Object中的方法
 * toString,equals的重写。
 * 
 * 该类的每一个实例表示直角坐标系中的一个点
 * @author Administrator
 *
 */
public class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point() {
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public String toString(){//重写Objetc的toString()方法;不重写输出的是句柄
		return "(" + x + "," + y + ")";
	}

	/*
		重写equals方法的要求：

		1、自反性：对于任何非空引用x，x.equals(x)应该返回true。

		2、对称性：对于任何引用x和y，如果x.equals(y)返回true，那么y.equals(x)也应该返回true。

		3、传递性：对于任何引用x、y和z，如果x.equals(y)返回true，y.equals(z)返回true，那么x.equals(z)也应该返回true。

		4、一致性：如果x和y引用的对象没有发生变化，那么反复调用x.equals(y)应该返回同样的结果。

		5、非空性：对于任意非空引用x，x.equals(null)应该返回false。

	 */
	public boolean equals(Object obj){//重写Objetc的equals()方法<改变了引用的代表方式>；不重写时引用的对比仅仅是对句柄的比较obj == this
		if(obj == null){//存在，不为空
			return false;
		}
		if(obj == this){//引用相同时
			return true;
		}
		if(obj instanceof Point){
			Point p = (Point)obj;
				return p.x==this.x&&p.y==this.y;//(返回表达式的boolean)引用的比较是对成员变量x,y值的比较
		}
		return false;
	}

	public static void main(String[] args) {
		Point  p = new Point(2,3);
		Point p1 = new Point(3,3);
//		System.out.println(p.toString());
		System.out.println(p.equals(p1));
	}
}
