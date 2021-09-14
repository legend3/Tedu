package day01;
/**
 * 查看当前字符串是否是以指定的字符串
 * 开始或结尾的
 * boolean startsWith(String str)
 * boolean endsWith(String str)
 * @author Administrator
 *
 */
public class StringDemo8 {
	public static void main(String[] args) {
		String str = "thinking in java";
		boolean starts = str.startsWith("thin");
		System.out.println("starts:" + starts);
		
		boolean ends = str.endsWith("ava");
		System.out.println("ends:" + ends);
	}
}





