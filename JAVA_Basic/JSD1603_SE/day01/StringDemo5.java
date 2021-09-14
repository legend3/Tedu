package day01;
/**
 * char charAt(int index)		与undexOf()相反
 * 获取当前字符串中指定位置上的字符
 * @author Administrator
 *
 */
public class StringDemo5 {
	public static void main(String[] args) {
		//            0123456789012345
		String str = "thinking in java";
		
		char c = str.charAt(9);
		System.out.println(c);
	}
}
