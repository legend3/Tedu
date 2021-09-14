package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 一次性写出一组字节
 * @author Administrator
 *
 */
public class RandomAccessFileDemo3 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf
			= new RandomAccessFile(
                "raf.txt","rw"
			);
		String str = "红鲤鱼绿鲤鱼与驴";
		/*
		 * 按照系统默认字符集将字符串转换为
		 * 一组字节
		 */
//		byte[] data = str.getBytes();
		//按照指定字符集转换
		byte[] data = str.getBytes("utf-8");
		/*
		 * void write(byte[] data)
		 * 将给定的字节数组中所有字节一次性写出
		 */
		raf.write(data);
		System.out.println("写出完毕!");
		raf.close();
		
	}
}





