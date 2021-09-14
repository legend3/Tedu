package day04;

import java.util.ArrayList;
import java.util.List;

/**
 * List提供了可以获取子集的方法:
 * List subList(int start,int end)
 * 获取当前集合中指定范围内的元素
 * @author Administrator
 *
 */
public class ListDemo2 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<10;i++){
			list.add(i);
		}
		System.out.println(list);
		/*
		 * 获取子集:
		 * [3,4,5,6,7]
		 */
		List<Integer> subList = list.subList(3, 8);
		System.out.println(subList==list);//false，产生了新对象
		/*
		 * 将子集所有元素扩大10倍
		 */
		for(int i=0;i<subList.size();i++){
			subList.set(i, subList.get(i) * 10);
		}
		System.out.println(subList);
		/*
		 * 对子集的修改就是修改元集合对应的元素
		 */
		System.out.println("元集合：" + list);
		
		/*
		 * 删除集合中3,4,5,6,7之间的元素
		 */
		list.subList(3, 8).clear();
		System.out.println(list);
	}
}







