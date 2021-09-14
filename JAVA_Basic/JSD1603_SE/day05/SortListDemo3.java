package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * Collections的sort方法有两个不足:
 * 1:要求我们的集合元素必须实现Comparable接口
 *   这样就对我们的类有较强的"侵入性"
 * 2:有时集合元素已经实现了Comparable接口并
 *   定义了比较大小的规则，但是该规则不满足我们
 *   对于排序的需求
 * Collections提供了一个重载的sort方法:
 * static void sort(List list,Comparator c)
 * 该重载方法要求我们传入一个额外的比较器，按照该比较器
 * 的规则来比较集合中的元素然后进行自然排序。    
 * @author Administrator
 *
 */
public class SortListDemo3 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("苍老师");
		list.add("小泽老师");
		list.add("范老师");	
		System.out.println(list);
//		Collections.sort(list);
		/*
		 * 当使用比较器来排序集合时，由于不再
		 * 使用元素自身的比较规则，所以该方法不再
		 * 要求元素必须实现Comparable接口，这样
		 * 就解决了侵入性问题。
		 * 第二、也解决了元素自身比较规则不满足排序
		 * 需求的问题。
		 * 以后工作中更常使用这个方法.
		 */
		MyComparator com = new MyComparator();
		Collections.sort(list, com);//将list中的元素放入com中compare()方法进行比较大小
		System.out.println(list);
	}
}
/**
 * Comparator支持泛型，泛型用来指定当前比较器要比较的元素的类型。
 * @author Administrator
 *
 */
class MyComparator implements Comparator<String>{
	/**
	 * 若返回值>0:o1>o2
	 * 若返回值<0:o1<o1
	 * 若返回值=0:o1==o2
	 */
	@Override
	public int compare(String o1, String o2) {
		return o1.length()-o2.length();
	}
	
}






