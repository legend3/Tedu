package day01;
/**
 * String 与 字符数组间的转换
 * 	String -> char[]：调用 String.toCharArray() 方法
 * 	char[] -> String：调用 String 的构造器
 * @author Administrator
 *
 */
public class StringDemo13 {
	public static void main(String[] args) {
		//String -> char[]
		String s1 = "hello";
		char[] chars = s1.toCharArray();
//		System.out.println(chars);
		for (char c1 : chars) {
			System.out.print(c1 + ", ");
		}
		System.out.println();
		//char[] -> String
		char[] c2 = new char[]{'h', 'e', 'l', 'l', 'o'};
		String s2 = new String(c2);
		System.out.println(s2);

	}
}




