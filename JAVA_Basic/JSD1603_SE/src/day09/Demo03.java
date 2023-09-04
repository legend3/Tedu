package day09;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Demo03 {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("obj.dat");
		ObjectInputStream in = new ObjectInputStream(
			new BufferedInputStream(fis)
		);
		/*
		 * 调用对象的反序列化方法读取对象
		 */
		Foo f = (Foo)in.readObject();//序列化对象转对象，反序列化
		in.close();
		System.out.println(f); 
	}

}
