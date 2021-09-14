package demo;

import java.util.Scanner;

public class Demo01 {

	public static void main(String[] args)
		throws Exception {
		Scanner in = new Scanner(System.in);
		/**
		 * 从控制台读取被加载的类名：包名.类名
		 */
		String className = in.nextLine();
		/**
		 * 从硬盘上动态加载类"类名.class"。
		 * 类加载到方法区，返回变量cls代表加载的
		 * 结果。如果类名错误，Java反射API没有
		 * 找到相应的类文件，就抛出:类没有找到异常
		 */
		Class cls = Class.forName(className);
		//输出类加载的结果
		System.out.println(cls);
	}

}
