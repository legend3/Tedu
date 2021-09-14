package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 使用新循环遍历集合
 * @author Administrator
 *
 */
public class NewForDemo2 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("#");
		c.add("three");
		c.add("#");
		c.add("four");
		/*
		 *	新循环并非新的语法，新循环是
		 *  编译器认可而不是虚拟机认可的。
		 *  编译器会在编译源代码的时候将
		 *  新循环替换。
		 *  使用新循环遍历集合就是使用迭代器
		 *  遍历。
		 *  所以使用新循环遍历集合时，
		 *  不能通过集合的方法增删元素。
		 *  新循环本身只是为了方便遍历使用。 
		 */
		for(Object o:c){
			String str = (String)o;
			System.out.println(str);
//			if("#".equals(str)){
//				c.remove(str);
//			}
		}
		System.out.println(c);
	}
}



