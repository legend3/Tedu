package day01;
/**
 * String 与 整型包装类间转换
 * 	String -> 基本数据类型、包装类：调用包装类的静态方法(parseXxx)
 * 	基本数据类型、包装类 -> String ：调用 String 重载的 ValueOf()方法
 * @author Administrator
 *
 */
public class StringDemo12 {
	public static void main(String[] args) {
		/*将字符串转换为整型类型*/
		String s1 = "123";
		int number = Integer.parseInt(s1);
		System.out.println(number);  //输出 123，但是是整型类型

		String str2 = String.valueOf(number);//int -> String
		System.out.println(str2);   //输出 123，但是是字符串类型

		String str3 = number + "";     //只要有变量参与，就存储在堆中
		System.out.println(System.identityHashCode(str3));
		System.out.println(System.identityHashCode(s1));
		System.out.println(s1 == str3);    //false
	}
}




