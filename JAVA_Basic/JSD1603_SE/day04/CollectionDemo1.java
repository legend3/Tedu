package day04;

import java.util.ArrayList;
import java.util.Collection;

/**
 * boolean remove(E e)
 * 删除集合中给定的元素，成功删除返回true
 * @author Administrator
 *
 */
public class CollectionDemo1 {
	public static void main(String[] args) {
		Collection c = new ArrayList();

		c.add(new Point(1,2));
		c.add(new Point(3,4));
		c.add(new Point(5,6));
		c.add(new Point(1,2));
		System.out.println(c);
		Point p = new Point(1,2);
		/*
		 * remove方法删除元素也是依靠元素自身
		 * equals比较的结果。
		 * remove会将给定元素依次与集合中每个元素
		 * 进行比较，然后删除第一个与给定元素equals
		 * 比较为true的元素后停止删除。
		 */
		System.out.println(c.contains(p));//false,因为p只是引用地址，集合存储的是元素的引用地址
		c.remove(p);//指定元素删除
		System.out.println("删除完毕");
		System.out.println(c);


		Collection cc = new ArrayList();
		cc.add("s1");
		cc.add("s2");
		cc.add("s3");
		cc.remove("s2");
		System.out.println("删除cc集合元素完毕");
		System.out.println(cc);
	}
}
