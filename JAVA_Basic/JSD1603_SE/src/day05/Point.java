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
	@Override
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		}
		if(obj == this){
			return true;
		}
		if (obj.getClass() !=getClass()) {
			return  false;
		}
		if(obj instanceof Point){//是否属于Point类型或者obj是否向上造型了
			Point p = (Point) obj;//大转小，指向小
			return p.getX() == this.getX()&&p.getY() == this.getY();
		}
		return false;
	}

	private volatile int hashCode;
	@Override
	public int hashCode() {
		int result = hashCode;
		if(result == 0) {
			result = Integer.hashCode(x);
			result = 31 * result + Integer.hashCode(y);
			hashCode = result;
		}
		return hashCode;
	}
}
