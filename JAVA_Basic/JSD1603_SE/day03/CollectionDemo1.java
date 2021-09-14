package day03;

import com.sun.deploy.util.StringUtils;

import java.util.*;

/**
 * java.util.Collection
 * 集合，可以存放一组元素
 * 集合提供了元素的相关维护操作。
 * 派生了两个子接口:
 * List:可重复集，ArrayList的父类又对List进行了实现
 * Set:不可重复集
 * @author Administrator
 *
 */
public class CollectionDemo1 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		/*
		 * boolean add(E e)
		 * 向集合当中添加一个元素，当成功
		 * 添加则返回true
		 */
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		
		System.out.println(c);
		
		/*
		 * int size()
		 * 获取当前集合中的元素个数
		 */
		System.out.println("size:"+c.size());
		
		/*
		 * boolean isEmpty()
		 * 判断集合是否不包含任何元素
		 */
		boolean isEmpty = c.isEmpty();
		System.out.println("isEmpty:"+isEmpty);
		
		/*
		 * void clear()
		 * 清空集合
		 */
		c.clear();
		System.out.println("清空集合!");
		
		System.out.println("size:"+c.size());
		System.out.println("isEmpty:"+c.isEmpty());
		System.out.println(c);

		//集合转数组
		List<String> list =new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		//通常我们传入的数组不需要给定长度
		String[] strArr = list.toArray(new String[] {});
		System.out.println(Arrays.toString(strArr));

		//数组转集合
		String[] strArr2 ={"a","b","c"};
		List<String> list2 =Arrays.asList(strArr);
		System.out.println(list2);// [a, b, c]
		list.add("d");//还是无法修改数组元素的
		System.out.println(Arrays.toString(strArr2));
		System.out.println("数组：" + list2);
		System.out.println(list2.getClass().getName());
		List<String> list3 = new ArrayList<String>();
		list3.addAll(list2);
		list3.add("d");
		System.out.println(list3);



		//集合排序
		List list5 = new ArrayList();
		for(int i=10;i>=0;i--){
			list5.add(i);
		}
		System.out.println(list5);
		Collections.sort(list5);
		System.out.println(list5);

	}
}
