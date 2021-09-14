package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 使用RandomAccessFile读取一个字节
 * @author Administrator
 *
 */
public class RandomAccessFileDemo2 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf
			= new RandomAccessFile(
                "raf.dat","r"
			);
		/*
		 * int read()
		 * 读取1个字节，并将该字节内容转换成
		 * 10进制后以int形式返回。
		 * 若返回的int值等于-1时，则说明读取
		 * 到了文件末尾。
		 * 
		 * 00000000 00000000 00000000 00000001
		 * 11111111 11111111 11111111 11111111
		 */
		int d = raf.read();
		System.out.println(d);
		
		raf.close();
	}
}





