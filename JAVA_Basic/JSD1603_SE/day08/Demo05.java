package day08;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 文件流
 */
public class Demo05 {

	public static void main	(String[] args) throws Exception{
		//打开被复制的文件（被读取的文件）
		FileInputStream in = new FileInputStream("demo.txt");
		//打开被写入的文件（复制目标文件）
		FileOutputStream out = new FileOutputStream("newOne.txt");
		int b;//b代表文件中的每个byte
		while((b = in.read())!=-1){
			out.write(b);
		}
		System.out.println("关闭");
		in.close();
		out.close();
	}
}










