package day05;

import java.util.HashMap;
import java.util.Map;

/**
 * java.util.Map
 * Map是一个接口，查找表。
 * Map是以key-value对的形式保存数据的。
 * Map的常用实现类:HashMap(散列表,哈希表,散列算法实现)
 *
 * @author Administrator
 *
 */
public class MapDemo1 {
	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		
		/*
		 * V put(K k,V v)
		 * 将给定的key-value存入到Map中。
		 * Map要求key不允许重复:Map中不能出现
		 * 两个key的equals判断为true。
		 * 若使用相同的key则是替换value操作，put
		 * 方法会将被替换的value返回。若给定的不是
		 * 重复的key,返回值为null。
		 */
		//不是重复的key,返回值为NULL
		Integer value = map.put("语文", 99);
		System.out.println(value);//null
		map.put("数学", 98);
		map.put("英语", 97);
		map.put("物理", 99);
		map.put("化学", 95);
		System.out.println(map);
		//替换value操作
		value = map.put("化学", 100);
		System.out.println(map);
		System.out.println("重复key返回值："+ value);//95
		
		/*
		 * V get(K k)
		 * 获取指定的key所对应的value
		 * 若指定的key在Map中不存在，则
		 * 返回null
		 */
		value = map.get("语文");
		System.out.println("语文:"+value);//99
		
		value = map.get("体育");
		System.out.println("体育:"+value);//null
		
		/*
		 * V remove(K k)
		 * 将给定的key所对应的key-value对
		 * 从Map中删除，返回值为对应的value
		 */
		value = map.remove("语文");
		System.out.println("删除的语文对应的值:"+value);
		System.out.println(map);
	}
}