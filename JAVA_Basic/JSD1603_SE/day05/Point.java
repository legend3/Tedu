package day05;
/**
 * 该类用于测试自定义的类型作为List集合
 * 元素进行排序使用。
 * @author Administrator
 *
 */
public class Point implements Comparable<Point>{
	private int x;
	private int y;
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
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
	public String toString(){
		return "("+x+","+y+")";
	}
	/**
	 * 该方法是用来判断当前对象与给定对象的
	 * 大小。
	 * 当返回值>0:当前对象比参数对象大
	 * 当返回值<0:当前对象比参数对象小
	 * 当返回值=0:两个对象相等。 
	 */
	@Override
	public int compareTo(Point o) {
		/*
		 * 判断大小规则:点到原点的距离长的大(勾股定理)
		 */
		int len = this.getX()*this.getY()+this.getY()*this.getY();//当前对象的值
		int olen = o.getX()*o.getX()+o.getY()*o.getY();//
		return len-olen;//当前对象是否大于目标对象
	}
}
