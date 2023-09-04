package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 泛型最常使用的地方就是集合
 * 泛型用来约束集合中的元素类型。
 * @author Administrator
 *
 */
public class CollectionDemo4 {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		/*
		 * boolean add(E e)
		 */
		c.add("one");
		c.add("two");
		c.add("three");
		System.out.println(c);
		/*
		 * 迭代器也支持泛型，该泛型的实际类型
		 * 应当与其遍历的集合的泛型实际类型一致。
		 */
		Iterator<String> it = c.iterator();
		while(it.hasNext()){
			String str = it.next();
			System.out.println(str);
		}

		for(String str:c){
			System.out.println(str);
		}


	}
}



