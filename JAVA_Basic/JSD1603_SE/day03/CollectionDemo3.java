package day03;


import java.util.ArrayList;
import java.util.Collection;


/**
 * 集合存放的是元素的引用
 * @author Administrator
 *
 */
public class CollectionDemo3 {
	public static void main(String[] args) {
		Point p = new Point(1, 2);
		Collection c = new ArrayList();
		c.add(p);
		System.out.println("p:"+p);
		System.out.println("c:"+c);
		
		p.setX(2);
		System.out.println("p:"+p);
		System.out.println("c:"+c);
	}
}
