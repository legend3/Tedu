package day02;

/**
 * 测试Point中重写的Object方法
 * @author Administrator
 *
 */
public class TestPoint{
	public static void main(String[] args) {
		Point p = new Point();
		p.setX(1);
		p.setY(2);
		/*
		 * Object中的toString返回一个
		 * 字符串。
		 * 通常我们使用一个类的toString方法
		 * 就应当重写它。
		 * toString方法返回的字符串中应当
		 * 包含当前对象中需要了解的属性信息。格式
		 * 根据实际需求而定。
		 * Object的toString返回的是对象的句柄，即
		 * 当前对象在内存中的地址，格式为:
		 * 类名@地址。一般没有实际意义。
		 */
		String str = p.toString();
		System.out.println(str);
		/*
		 * System.out.println(Object o)
		 * 该方法会将给定对象的toString方法
		 * 返回的字符串输出到控制台。
		 */
		System.out.println(p);
		
		
		Point p1 = new Point();
		p1.setX(1);
		p1.setY(2);
		System.out.println(p1);

		System.out.println(p==p1);
		/*
		 * 通常使用一个对象的equals方法时，就
		 * 应当重写它。
		 * Object提供的equals方法就是用"=="
		 * 比较的。
		 * equals方法的实际作用是比较两个对象
		 * "像不像"，即:两个对象内容是否相同。
		 * 内容指的是对象的属性值。
		 * 在比较内容是否相同时，并非要求所有属性
		 * 值都要相同，这要结合实际需求而定。
		 */
		System.out.println(p.equals(p1));
	}
}
