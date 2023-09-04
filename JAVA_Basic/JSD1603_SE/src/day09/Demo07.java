package day09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Demo07 {
	/**
	 * 文本文件读
	 */
	public static void main(String[] args) throws Exception{
		BufferedReader in =
			new BufferedReader(//文本文件流
				new InputStreamReader(//字符流
					new FileInputStream(//字节流
			"JAVA_Basic/JSD1603_SE/day01/DocDemo.java"),
			"GBK"));
		String str;
		//每次从文件中读取一行文本，如果返回null表示读取到文件的末尾
		while((str=in.readLine())!=null){
			System.out.println(str);
		}
		in.close();

	}

}