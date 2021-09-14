package day08;

import java.io.RandomAccessFile;

public class Demo04 {
	public static void main(String[] args) 
		throws Exception {
		RandomAccessFile raf = 
			new RandomAccessFile("test.dat", "rw");
		System.out.println(
			raf.getFilePointer());//0
		raf.write(0x42);
		System.out.println(
			raf.getFilePointer());//1
		raf.writeInt(0x41def712);
		System.out.println(
			raf.getFilePointer());//5
		//读取 int 数据
		raf.seek(1);//跳到int数据开始的位置
		int n = raf.readInt();
		System.out.println(Integer.toHexString(n));
		System.out.println(raf.getFilePointer());//5
		raf.close();
	}

}
