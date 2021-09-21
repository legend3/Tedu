package day09;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Demo07 {
	/**
	 * 文本文件读
	 */
	public static void main(String[] args) throws Exception{
		BufferedReader in = 
			new BufferedReader(
				new InputStreamReader(
					new FileInputStream(
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
