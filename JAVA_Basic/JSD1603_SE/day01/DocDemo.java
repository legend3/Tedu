package day01;
/**
 * 文档注释是用来修饰:类，方法，常量的
 * 文档注释最终会被javadoc命令解读从而
 * 为当前类生成一个文档手册
 *
 * 在类上使用是用来说明当前类的作用
 * @author Administrator
 * @version 1.0 2016-04-22
 * @see java.lang.String
 * @since JDK1.0
 *
 */
public class DocDemo {
	/**
	 * sayHello方法用到的问候短语
	 */
	public static final String INFO = "你好!";

	/**
	 * 该方法返回一个针对给定用户的问候语
	 * @param name 指定的用户名
	 * @return 含有问候语的字符串
	 */
	public static String sayHello(String name){
		return INFO+name;
	}
}





