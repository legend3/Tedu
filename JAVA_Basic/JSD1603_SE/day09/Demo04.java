package day09;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * 字符流：是高级流，必须依赖低级的byte流，字符流封装了字符的编码和解码功能，能够将字符数据编码序列化为byte写到低级流中，或将byte字符数据解码为字符数据。
 */
public class Demo04 {

	public static void main(String[] args) throws Exception{
		String s = "你吃了吗？\n";
//		FileOutputStream fos = new FileOutputStream("d.txt");
		OutputStreamWriter writer = new OutputStreamWriter(
				new FileOutputStream("d.txt"),"UTF-8");
		//字符流将字符数据编码为byte写到低级流
		writer.write(s);
		writer.close();


	}

}
