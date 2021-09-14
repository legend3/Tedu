package day01;
/**
 * 字符串提供了很多重载的静态方法:
 * static String valueOf(...)
 * 作用是将其他类型数据转换为字符串
 * 常用的是将基本类型转换为字符串形式。
 * @author Administrator
 *
 */
public class StringDemo9 {
	public static void main(String[] args) {
		int i = 123;
		String str = String.valueOf(i);
		System.out.println(str+4);//有一边是字符串后边就全是字符串运算
		
		double d = 123.123;
		str = String.valueOf(d);
		System.out.println(str+4);

	}
}






