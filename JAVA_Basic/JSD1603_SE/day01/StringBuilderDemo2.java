package day01;
/**
 * StringBuilder修改字符串效率(避免了String修内容的Java heap space内存问题)
 * @author Administrator
 *
 */
public class StringBuilderDemo2 {
	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder("a");
		for(int i=0;i<10000000;i++){
			builder.append("a");
		}
		System.out.println(builder);
	}
}




