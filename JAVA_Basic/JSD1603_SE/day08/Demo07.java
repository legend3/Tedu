package day08;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class Demo07 {

	public static void main(String[] args) throws Exception{
		FileOutputStream fos = new FileOutputStream("test.txt");
		//创建缓冲输出流bos，必须依赖于节点流fos
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		//bos的写出方法先将数据写到缓冲区
		//当缓冲区满了再写到文件中。
		bos.write("HelloWorld".getBytes());
		//flush方法作用：检查缓冲区中是否有数据，
		//如果有数据就将数据强行写文件。
		bos.flush();
		
		//bos关闭方法先检查缓冲区是否有数据，如果有数据
		//将数据写到文件中，再关闭文件。
		bos.close();
	}
}
