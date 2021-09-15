package day09;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Demo05 {

	public static void main(String[] args) throws Exception{
//		FileInputStream fis = new FileInputStream("d.txt");
		//字符输入流(输入到内存)
		InputStreamReader reader = new InputStreamReader(
				new FileInputStream("d.txt"), "UTF-8");
		int c;
		while((c = reader.read())!=-1){
			char ch = (char)c;
			System.out.print(ch);
		}
		reader.close();
	}

}
