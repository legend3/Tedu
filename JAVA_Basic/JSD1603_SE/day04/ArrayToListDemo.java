package day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组转换为集合
 * 使用Arrays的静态方法可以转换为一个List集合
 * 数组职能转换为List集合
 * @author Administrator
 *
 */
public class ArrayToListDemo {
	public static void main(String[] args) {
		String[] array = {"one","two","three","four"};
		/*
		 * 将给定的数组转换为List集合
		 */
		List<String> list = Arrays.asList(array);//数组转集合
		System.out.println(list.size());
		System.out.println(list);
		
		list.set(1, "2");
		System.out.println(list);
		for(String str : array){
			System.out.println(str);
		}
		/*
		 * 对于数组转换来的集合，不可以添加
		 * 新元素。
		 */
//		list.add("five");
		/*
		 * 所有的集合都支持一个含有Collection类型
		 * 作为参数的构造方法。该构造方法又称为复制
		 * 构造器。
		 * 可以在创建当前集合的同时包含给定集合中的
		 * 所有元素。
		 */
		List<String> list1 = new ArrayList<String>(list);
		System.out.println("list1:"+list1);
		
		list1.add("five");
		System.out.println("list1:"+list1);
	}
}


