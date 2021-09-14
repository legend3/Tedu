package day04;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合转换为数组
 * Collection提供了一个方法toArray可以将
 * 当前集合转换为一个数组
 * @author Administrator
 *
 */
public class CollectionToArrayDemo {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		c.add("one");
		c.add("two");
		c.add("three");	
//		Object[] array = c.toArray();		
		String[] array = c.toArray(new String[c.size()]);//集合转数组
		System.out.println(array.length);
		for(String str : array){
			System.out.println(str);
		}
	}
}






