package day04;

import java.util.ArrayList;
import java.util.List;

/**
 * java.util.List
 * 可重复集，且有序。
 * 特点是可以通过下标操作元素，与数组很相似
 * 常用实现类:
 * ArrayList:内部由数组实现，查询快
 * LinkedList:内部由链表实现，增删快,尤其首尾增删
 * 
 * @author Administrator
 *
 */
public class ListDemo1 {
	public static void main(String[] args) {
		/*
		 * List提供了一些独有的方法，特点都是
		 * 可以根据下表操作元素。
		 * 
		 * E get(int index)
		 * 获取指定位置上的元素。
		 */
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		System.out.println(list);
		//获取第二个元素
		String str = list.get(1);
		System.out.println(str);
		
		for(int i=0;i<list.size();i++){
			str = list.get(i);
			System.out.println(str);
		}
		
		/*
		 * E set(int index,E e)
		 * 将给定的元素设置到指定位置上，返回值
		 * 为原位置上的元素，所以是替换元素操作
		 */
		System.out.println(list);
		
		//[one, 2, three, four]
		String old = list.set(1, "2");
		System.out.println(list);
		System.out.println("old:"+old);
		
		/*
		 * void add(int index,E e)
		 * 在指定位置插入一个元素，原位置及后续
		 * 元素顺序向后移动。
		 */
		//[one, 2, 3, three, four]
		list.add(2,"3");
		System.out.println(list);
		
		/*
		 * E remove(int index)
		 * 从集合中删除并返回指定位置上的元素
		 */
		//[one, 2, 3, four]
		old = list.remove(3);//指定下标删除
		System.out.println(list);
		System.out.println("old:"+old);
	}
}





