package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 排序自定义类型元素
 * @author Administrator
 *
 */
public class SortListDemo2 {
	public static void main(String[] args) {
		List<Point> list = new ArrayList<Point>();
		list.add(new Point(4,5));
		list.add(new Point(9,6));
		list.add(new Point(5,8));
		list.add(new Point(3,7));
		
		System.out.println("原始集合：" + list);
		/*
		 * 数值
		 * Collections的sort方法要求
		 * 排序的集合中元素必须实现Comparable接口。
		 * 该接口用于表示可比较。其提供了一个抽象方法comparaTo用于定义比较规则。
		 */
		Collections.sort(list);//按照自定义规则得出元素大小，再sort从小到大排序
		System.out.println("比较后的集合：" + list);
	}
}
