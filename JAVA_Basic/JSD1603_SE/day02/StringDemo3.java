package day02;
/**
 * String replaceAll(String regex,String str)
 * 将当前字符串中满足正则表达式的部分替换为
 * 给定的字符串
 * @author Administrator
 *
 */
public class StringDemo3 {
	public static void main(String[] args) {
		String str = "abc123def456ghi789abc";
		/*
		 * 将数字部分替换为"#NUMBER#"
		 */
		String regex = "[0-9]+";
		str = str.replaceAll(regex, "#NUMBER#");
		System.out.println(str);

		/*
		* replace() 方法通过用 newChar 字符替换字符串中出现的所有 oldChar 字符，并返回替换后的新字符串。
		* */
		str = str.replace('a', '@');
		System.out.println(str);
		
	}
}







