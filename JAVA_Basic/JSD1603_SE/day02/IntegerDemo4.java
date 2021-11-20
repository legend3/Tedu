package day02;
/**
 * JDK1.5之后推出了一个新的特性
 * 自动拆装箱
 * 编译器可以自行补充代码来完成基本类型与引用类型
 * 的互转。
 * @author Administrator
 *
 */
public class IntegerDemo4 {
	public static void main(String[] args) {
		/*
		 * 自动拆箱:
		 * 编译器补充代码来完成从引用类型到基本类型的转换。
		 *
		 * 下面的代码在.class文件中:
		 * int i = new Integer(1).intValue();
		 */
		int i = new Integer(1);//拆箱
		System.out.println(i);
		/*
		 * 自动装箱:
		 * 编译器补充代码来完成从基本类型到
		 * 引用类型的转换。
		 * 下面的代码在.class文件中:
		 * Integer ii = Integer.valueOf(1);
		 */
		Integer ii = 1;//int自动给转Integer，自动装箱
		System.out.println(ii);
		System.out.println(ii.getClass().getName());
	}
}




