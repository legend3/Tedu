package day01;
/**
 * StringBuilder是为了修改字符串内容
 * 而出现的类。
 * 该类定义了用于编辑字符串的相关方法:
 * 增，删，改，插
 * @author Administrator
 *
 */
public class StringBuilderDemo {
	public static void main(String[] args) {
		String str = "好好学习java";
		//String-->StringBuilder
		StringBuffer builder
				= new StringBuffer(str);

		//StringBuilder-->String
		str = builder.toString();
		System.out.println(str);

		/*
		 * StringBuilder append(String str)
		 * 向当前字符串末尾追加指定内容
		 *
		 * 好好学习java,为了找个好工作!
		 */
		builder.append(",为了找个好工作!");
		System.out.println(builder.toString());

		/*
		 * StringBuilder(
		 *  int start,int end,String str)
		 * 将当前字符串中指定范围内的内容替换为
		 * 给定字符串
		 * 好好学习java,为了找个好工作!
		 * 好好学习java,就是为了改变世界!
		 */
		builder.replace(9, 17, "就是为了改变世界!");
		System.out.println(builder.toString());

		/*
		 * StringBuilder delete(
		 * 			int start,int end)
		 * 删除指定范围内的字符串
		 *
		 * 好好学习java,就是为了改变世界!
		 * ,就是为了改变世界!
		 */
		builder.delete(0, 8);
		System.out.println(builder.toString());

		/*
		 * StringBuilder insert(
		 * 			int offset,String str)
		 * 向当前字符串指定位置处插入指定内容
		 *
		 * ,就是为了改变世界!
		 * 活着,就是为了改变世界!
		 */
		builder.insert(0, "活着");
		System.out.println(builder.toString());

		builder.reverse();
		System.out.println(builder.toString());
	}
}








