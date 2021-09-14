package day04;
/**
 * 测试泛型的类型
 * @author Administrator
 *
 */
public class TestPoint2 {
	public static void main(String[] args) {
		Point<Integer> p1 = new Point<Integer>(1,2);
		p1.setX(2);
		int x1 = p1.getX();
		System.out.println("x1:"+x1);
		System.out.println("p1:"+p1);
		//不指定泛型默认就是Object
		Point p2 = p1;
		p2.setX("二");
		String x2 = (String)p2.getX();
		System.out.println("x2:"+x2);
		System.out.println("p2:"+p2);
		
		//类造型异常!
		x1 = p1.getX();
		System.out.println("x1:"+x1);
	}
}



