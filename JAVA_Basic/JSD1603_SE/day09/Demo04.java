package day09;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class Demo04 {

	public static void main(String[] args) 
		throws Exception{
		String s = "你吃了吗？\n";
		FileOutputStream fos = 
			new FileOutputStream("d.txt");
		OutputStreamWriter writer = 
			new OutputStreamWriter(fos,"UTF-8");
		//字符流将字符数据编码为byte写到低级流
		writer.write(s);
		writer.close();


	}

}
