package day03;


import java.util.ArrayList;
import java.util.Collection;




/**
 * boolean contains(E e)
 * 判断集合是否包含指定元素
 * @author Administrator
 *
 */
public class CollectionDemo2 {
	public static void main(String[] args) {
		Collection c = new ArrayList();

		c.add(new Point(1,2));
		c.add(new Point(3,4));
		c.add(new Point(5,6));
		
		System.out.println(c);
		
		Point p = new Point(1,2);
//		c.add(p);
		/*
		 * 判断包含是根据给定元素与集合现有元素
		 * 有没有equals比较为true的，有,则认为
		 * 是包含。
		 */
		boolean contains = c.contains(p);
		System.out.println("包含:"+contains);
		
	}
}





