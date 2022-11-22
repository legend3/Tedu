package day07;

import java.io.RandomAccessFile;

public class Demo03 {

	public static void main(String[] args) throws Exception{
		RandomAccessFile raf = new RandomAccessFile("demo.dat", "rw");
		int n = 2182218;
		//writeInt 方法将int n拆分为4个
		//byte连续写到文件中
		raf.writeInt(n);
		//seek 方法将文件的指针位置重新移动到文件 的开头位置
		raf.seek(0);
		//readInt方法从文件中连续读取4个byte并且拼接为一个int数据
		int m = raf.readInt();	
		raf.close();
		System.out.println(m); 
		//writeInt 和 readInt 是一对读写方法，一个是将整数拆分写到文件中
		//一个是从文件读取byte拼接为int
		
	}
}
