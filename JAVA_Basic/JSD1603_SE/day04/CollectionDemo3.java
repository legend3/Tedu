package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 遍历集合元素
 * Iterator iterator()
 * 集合提供了该方法用来获取一个可以遍历当前
 * 集合元素的迭代器。
 * Iterator是一个接口，定义了遍历集合的相关
 * 方法。不同的集合有不同的实现类。我们无需记住
 * 实现类的名字，只将它们看做是Iterator即可。
 * 
 * 使用迭代器遍历集合遵循:
 * 问,取,删
 * 其中删除不是必须操作。
 * 
 * @author Administrator
 *
 */
public class CollectionDemo3 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("#");
		c.add("three");
		c.add("#");
		c.add("four");
		System.out.println(c);
		
		Iterator it = c.iterator();
		/*
		 * boolean hasNext()
		 * 通过迭代器判断集合是否还有元素
		 * 可以遍历
		 */
		while(it.hasNext()){
			String str = (String)it.next();
			if("#".equals(str)){
				/*
				 * 在使用迭代器遍历集合的过程中，不能通过
				 * 集合的方法增删元素，否则会抛出异常
				 */
//				c.remove(str);
				/*
				 * 删除通过next取出的元素
				 */
				it.remove();
			}
			System.out.println(str);
		}
		System.out.println(c);
	}
}








