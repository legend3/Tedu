package day06;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.io.File
 * File的每一个实例用于表示操作系统中文件系统
 * 中的一个文件或目录(硬盘上的一个文件或目录)
 * 
 * 当使用File表示一个文件或目录时，可以:
 * 1:访问该文件或目录的属性信息，
 *   例如:文件名，最后修改时间，文件大小等。
 * 2:可以操作文件或目录(创建，删除)
 * 3:可以访问该目录的所有子项
 * 但是不能访问文件数据。
 *   
 * 
 * @author Administrator
 *
 */
public class FileDemo1 {
	public static void main(String[] args) {
		/*
		 * 路径应当写相对路径。避免系统差异。
		 */
		File file = new File("." + File.separator + "demo.txt");//已存在的我呢见
		//获取文件的路径

//		System.out.println("文件的绝对路径: " + file.getAbsolutePath());
//		System.out.println(file.getPath());
//		System.out.println(file.toPath());
		//获取文件或目录的名字
		String name = file.getName();
		System.out.println("FileName: "+name);
		//获取大小(字节量)
		long length = file.length();
		System.out.println("大小:"+length+"字节");
		//是否为隐藏文件
		boolean isHidden = file.isHidden();
		System.out.println("隐藏文件:"+isHidden);
		//是否可读
		boolean canRead = file.canRead();
		System.out.println("可读:"+canRead);
		//是否可写
		boolean canWrite = file.canWrite();
		System.out.println("可写:"+canWrite);
		//最后修改 时间2016年4月29日, 09:32:04
		long time = file.lastModified();
		Date date = new Date(time);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月d日, HH:mm:ss");
		System.out.println("最后修改时间:"+sdf.format(date));
	}
}







