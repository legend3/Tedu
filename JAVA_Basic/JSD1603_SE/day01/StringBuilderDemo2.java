package day01;
/**
 * StringBuilder修改字符串效率
 * @author Administrator
 *
 */
public class StringBuilderDemo2 {
	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder("a");
		for(int i=0;i<10000000;i++){
			builder.append("a");
		}
	}
}




