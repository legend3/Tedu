package day09;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Demo01 {

	public static void main(String[] args) throws Exception{
//		FileInputStream fis = 
//			new FileInputStream("movie.flv");
//		FileOutputStream fos = 
//			new FileOutputStream("new.flv");
//		BufferedInputStream in=
//			new BufferedInputStream(fis);
//		BufferedOutputStream out=
//			new BufferedOutputStream(fos);
		BufferedInputStream in = new BufferedInputStream(new FileInputStream("../../movie.flv"));//被读取的文件的缓冲流
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("new.flv"));//被写入的文件的缓冲流
		int b;
		while((b = in.read())!=-1){
			out.write(b);
		}
		in.close();
		out.close();
		System.out.println("OK");
	}

}
