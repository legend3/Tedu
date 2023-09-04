package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * 集合批操作
 * @author Administrator
 *
 */
public class CollectionDemo2 {
	public static void main(String[] args) {
		Collection c1 = new HashSet();
		c1.add("java");
		c1.add(".net");
		c1.add("c++");
		
		Collection c2 = new ArrayList();
		c2.add("c");
		c2.add("php");
		c2.add("java");

		/*
		 * boolean addAll(Collection c)
		 * 将给定集合中的所有元素添加到当前集合中
		 * 当添加后当前集合元素发生了变化就返回true
		 */
		boolean tf = c1.addAll(c2);
		System.out.println(tf);
		System.out.println(c1);
		
		/*
		 * boolean containsAll(Collection c)
		 * 判断当前集合是否包含给定集合中的所有元素
		 */
		Collection c3 = new ArrayList();
		c3.add("c++");
		c3.add("php");
		c3.add("oc");
		boolean contains = c1.containsAll(c3);
		System.out.println("全包含:"+contains);
		/*
		 * boolean removeAll(Collection c)
		 * 删除当前集合中与给定集合相同的元素。
		 * 删除后当前集合元素发生了变化则返回true.
		 */
		tf = c1.removeAll(c3);
		System.out.println(tf);
		System.out.println(c1);
		
		
		
	}
}




