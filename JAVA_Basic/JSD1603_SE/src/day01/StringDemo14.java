package day01;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * String 与 byte[] 之间的转换
 * 	编码：String -> byte[] ，调用 String 的 getBytes() 方法
 * 	解码：byte[] -> String ，调用 String 的构造器
 * 	编码：字符串 > 字节（转换成二进制数据）
 * 	解码：编码的逆过程，字节 > 字符串
 * @author Administrator
 *
 */
public class StringDemo14 {
	public static void main(String[] args) {
		//使用默认的字符集编码
		String s1 = "Hello，中国";
		byte[] bytes = s1.getBytes();
		System.out.println("使用默认的字符集编码: " + Arrays.toString(bytes));

		//强制使用GBK编码集编码
		byte[] gbks = new byte[0];
		try {
			gbks = s1.getBytes("GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("强制使用GBK编码集编码: " + Arrays.toString(gbks));

		//解码使用默认的字符集的编码
		String s2 = new String(bytes);
		System.out.println("使用默认的字符集解码: " + s2);

		//解码使用GBK编码集的编码
		String s3 = new String(gbks);
		System.out.println("使用GBK编码集解码: " + s3);//出现乱码，原因：编码集与解码集不一致

		//使用GBK解码编码使用GBK编码集的编码
		String s4 = null;
		try {
			s4 = new String(gbks, "GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(s4);
		/**
		*
		* 总结：字符串编码成byte使用什么编码集，解码就同样使用什么编码集！
		*/
	}
}




