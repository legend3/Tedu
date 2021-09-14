package day12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 1.ArrayList,LinkedList,HashSet都不是线程安全的,
 * Map常用实现类HashMap也不是线程安全的。 
 * 而线程安全的List是Vector.
 * 线程安全的Map的实现类是HashTable
 * 2.可以使用Collections提供的静态方法可以将当前的
 * 集合或Map转换为线程安全的。
 * @author adminitartor
 *
 */
public class SyncApiDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		/*
		 * 将给定的List集合转换为线程安全的集合。
		 * 返回的集合中仍然包含所有元素。
		 */
		list = Collections.synchronizedList(list);
		System.out.println(list);
		
		//HashSet不是线程安全的
		Set<String> set = new HashSet<String>(list);
		//转换为线程安全的Set集合
		set = Collections.synchronizedSet(set);
		System.out.println(set.getClass());
		
		//HashMap也不是线程安全的
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("语文", 99);
		map.put("数学", 98);
		map.put("英语", 97);
		map = Collections.synchronizedMap(map);
		System.out.println(map.getClass());

		getKeyThread g1 = new getKeyThread();
		getKeyThread g2 = new getKeyThread();
		g1.map = map;
		g2.map = map;

		g1.setName("T1");
		g2.setName("T2");
		
		g1.start();
		g2.start();
	}
}

class getKeyThread extends Thread{
	Map<String, Integer> map;
	@Override
	public void run() {
		Thread t = Thread.currentThread();
		for(String key:map.keySet()){
			System.out.println(t.getName() + " " + key);
		}
	}
}