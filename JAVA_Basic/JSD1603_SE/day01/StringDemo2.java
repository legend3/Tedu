package day01;
/**
 * int indexOf(String str)
 * 查看指定内容在当前字符串中的位置。
 * @author Administrator
 *
 */
public class StringDemo2 {
	public static void main(String[] args) {
//		              0123456789012345 
		String str = "thinking 99 in java";
		
		int index = str.indexOf("in");
		System.out.println("index:"+index);
		/*
		 * 重载方法允许从指定位置处开始查找
		 * 指定字符串第一次出现的位置
		 */
		index = str.indexOf("in",3);
		System.out.println("index:"+index);
		
		/*
		 * int lastIndexOf(String str)
		 * 返回指定字符串在当前字符串中最后一次
		 * 出现的位置
		 */
		index = str.lastIndexOf("in");
		System.out.println("index:"+index);

		/*
		* java.lang.String.indexOf(int ch) 方法返回該字符串指定字符第一次出現处的索引。
		* 如果在通過第一這樣發生的這個字符串對象，則索引(Unicode代碼單元)所表示的字符序列ch值的字符被返回。
		* */
		System.out.println(str.indexOf('j'));
	}
}



