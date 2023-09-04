package day09;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Demo02 {

	public static void main(String[] args) throws Exception {
		//对象
		Foo foo = new Foo(3, "Tom");
		/*
		 * 先创建低级流（节点流）
		 */
		FileOutputStream fos = new FileOutputStream("obj.txt");
		/*
		 * 创建对象输出流,是一种高级流，需要
		 * 依赖低级流。
		 */
		ObjectOutputStream out = new ObjectOutputStream(fos);
		/*
		 * 使用高级流提供的算法（方法）将
		 * 对象序列化写到文件中
		 */
		out.writeObject(foo);
		System.out.println("关闭");
		out.close();
	}
}





