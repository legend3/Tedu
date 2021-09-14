package day06;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读取一组字节
 * @author Administrator
 *
 */
public class RandomAccessFileDemo4 {
	public static void main(String[] args)throws IOException {
		RandomAccessFile raf
			= new RandomAccessFile(
                "raf.txt","r"
			);		
		byte[] buf = new byte[100];
		/*
		 * int read(byte[] d)
		 * 一次性尝试读取给定字节数组总长度的
		 * 字节量，并存入到这个数组中，返回值为
		 * 实际读取到得字节量,若返回值为-1,则
		 * 说明读取到了文件末尾(本次什么都没有读到)
		 */
		int len = raf.read(buf);
		System.out.println(
			"实际读取到了:"+len+"个字节");
		String str = new String(
			buf,0,len,"UTF-8"
		);
		System.out.println(str);
		raf.close();
		
	}
}

