package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * List集合的排序
 * 排序List集合使用集合的工具类Collections
 * 的静态方法sort.该方法可以对指定List集合进行
 * 自然排序(从小到大)
 * @author Administrator
 *
 */
public class SortListDemo1 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		Random random = new Random();
		for(int i=0;i<10;i++){
			list.add(random.nextInt(100));
		}
		System.out.println(list);
		Collections.sort(list);//排序，由小到大
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);//排序，由大到小
	}
}






