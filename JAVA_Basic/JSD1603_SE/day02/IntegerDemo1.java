package day02;
/**
 * 包装类
 * 由于基本类型不能直接参与面向对象开发， 对此
 * java为8个基本类型分别定义了对应的包装类。
 * 其中6个数字类型的包装类都继承自Number类。
 * Number定义了数字类型互转的方法，所以每个包装
 * 类都可以将其表示的基本类型转换为其他表示数字
 * 的基本类型。
 * @author Administrator
 *
 */
public class IntegerDemo1 {
	public static void main(String[] args) {
		double d = 1.1;
		/*
		 * 基本类型转换为包装类
		 */
		Double dou = Double.valueOf(d);

		/*
		包装类转换基本类型
		*/
		d = dou.doubleValue();
		System.out.println(d);	
		int i = dou.intValue();
		System.out.println(i);		
		short s = dou.shortValue();
		System.out.println(s);
		long l = dou.longValue();
		System.out.println(l);
		float f = dou.floatValue();
		System.out.println(f);

		System.out.println(String.valueOf(123));//转成字符串
	}
}







