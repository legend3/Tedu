package Basic.day02;

import java.util.Scanner; //1.
/**
 * Scanner的演示
 * 1.通过 Scanner 类来获取用户的输入
 * 2.通过 Scanner 类的 next() 与 nextLine() 方法获取输入的字符串，
 * 并在读取前我们一般需要 使用 hasNext 与 hasNextLine 判断是否还有输入的数据
 *
 * next() 与 nextLine() 区别
 *
 * next():
 * 0、可以读取基本类型！
 * 1、一定要读取到有效字符后才可以结束输入。
 * 2、对输入有效字符之前遇到的空白，next() 方法会自动将其去掉。
 * 3、只有输入有效字符后才将其后面输入的空白作为分隔符或者结束符。
 * next() 不能得到带有空格的字符串。
 *
 * nextLine()：
 * 0、一定是String字符串
 * 1、以Enter为结束符,也就是说 nextLine()方法返回的是输入回车之前的所有字符。
 * 2、可以获得空白。
 */

public class ScannerDemo {
	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in); //2.System.in从键盘接收数据,也可用输入流
//		int age = 0;
//		double price = 0.0;
//		System.out.println("请输入年龄:");
//		if(scan.hasNextInt()) {
//			age = scan.nextInt(); //3.通过 Scanner 类的 next() 与 nextLine() 方法获取输入的字符串
//			System.out.println(age);
//		}
//		System.out.println("请输入消费的金额:");
//		if(scan.hasNextDouble()){
//			price = scan.nextDouble();
//			System.out.println(price);
//		}
//		scan.close();

		Scanner scan2 = new Scanner(System.in);
//		scan2.close();
		try{
			String name = scan2.findInLine("茶叶");//指定要被搜索的匹配字符串，返回匹配到的内容，没有返回null
			System.out.println(name);
		}catch(IllegalStateException e){//捕获如果此扫描仪已关闭而抛出异常
			e.printStackTrace();
		}
		scan2.close();
	}
}

