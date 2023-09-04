package day02;
/**
 * 包装类都支持一个静态方法。
 * 可以将字符串转换为对应的基本类型值
 * 前提是该字符串必须正确描述该基本类型可以保存的值
 * @author Administrator
 *
 */
public class IntegerDemo3 {
	public static void main(String[] args) {
		String str = "123";
		/*
			字符串数字转包装类型
		 */
		int i = Integer.parseInt(str);//对应String.valueOf(int)
		System.out.println(i+1);
		
		double d = Double.parseDouble(str);
		System.out.println(d+1);
	}
}