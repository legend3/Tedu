package day01;
/**
 * 字符串是不变对象
 * 意思是:当字符串对象创建后，该对象表示的
 * 字符串内容是不可变的，若改变内容一定会
 * 创建新对象。
 * @author Administrator
 *
 */
public class StringDemo {
	public static void main(String[] args) {
		/*
		 * 当使用字面量创建字符串对象时，会重用内容相同的字符串对象。
		 */
		String s1 = "HelloWorld";
		String s2 = "HelloWorld";
		System.out.println(s1==s2);
		/*
		 * new一定会创建新对象
		 */
		String s3 = new String("HelloWorld");
		System.out.println(s3);
		System.out.println(s1==s3);
		/*
		 * 编译器有一个优化措施，当遇到一个计算
		 * 表达式时，发现计算符两边的内容都是字面量
		 * 时，会直接进行计算，然后将结果编译到class
		 * 文件中，所以下面的代码在class文件中的样子
		 * 是:
		 * String s4 = "HelloWorld";
		 */
		String s4 = "Hello"+"World";
        System.out.println(s1==s4);//true
		/*
		 * 下面的操作不会在变异的时候直接计算。
		 * 而改变字符串内容一定会创建新对象。
		 */
		String s5 = "Hello";
		String s6 = "World";
		String s7 = s5+s6;
		System.out.println("s7: "+s7);
		System.out.println(s1==s7);//false


		/**
		 * 修改内容后是否还是同意对象?
		*/
		String s8 = "你好！";
		System.out.println(System.identityHashCode(s8));//可以返回对象的内存地址,不管该对象的类是否重写了hashCode()方法
		s8 = "你好吗？";
		System.out.println(System.identityHashCode(s8));//可以返回对象的内存地址,不管该对象的类是否重写了hashCode()方法

		String s9 = "Hello World!";
		System.out.println(System.identityHashCode(s9));
		String s10 = "Hello World!";
		System.out.println(System.identityHashCode(s10));
		/**
		 * 总结：涉及字符串(包括字符串相加)，字符串最终相同的，都是同一个对象！
		 */

	}
}
