package day05;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Map的遍历 遍历Map有三种方式:
 * 1:遍历所有的key
 * 2:遍历所有的key-value对
 * 3:遍历所有的value(相对不常用)
 * 
 * @author Administrator
 * 
 */
public class MapDemo2 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("语文", 99);
		map.put("数学", 98);
		map.put("英语", 97);
		map.put("物理", 99);
		map.put("化学", 95);
		
		/*
		 * 1.Set<K> keySet(),依据key遍历出value
		 */
		Set<String> keySet = map.keySet();
		System.out.println(keySet.getClass().getName());
		System.out.println(keySet);
		for(String key : keySet){
			System.out.println("key:"+key);
		}
		
		/*
		 * 2.Set<Entry> entrySet
		 * Entry是Map的内部类，每一个Entry
		 * 实例都表示Map中的一组key-value对
		 * Entry提供了获取key,value的方法:
		 * K getKey(),V getValue()
		 * 
		 * entrySet方法则是将每一组key-value
		 * 对(即:若干Entry实例)存入一个Set集合
		 * 后返回。
		 */
		Set<Entry<String,Integer>> entrySet = map.entrySet();//map转set
		System.out.println(entrySet);
		for(Entry<String,Integer> e :entrySet){
			String key = e.getKey();
			Integer value = e.getValue();
			System.out.println(key+":"+value);
		}
		/*
		 * 3.Collection<V> values()
		 * 将Map中所有的value存入一个集合后返回。(少用)
		 */
		Collection<Integer> values = map.values();
		System.out.println(values);
		for(Integer value : values){
			System.out.println("value:"+value);
		}
	}
}