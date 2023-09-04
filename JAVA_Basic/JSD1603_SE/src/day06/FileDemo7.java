package day06;

import java.io.File;

/**
 * 获取一个目录中的所有子项
 * @author Administrator
 *
 */
public class FileDemo7 {
	public static void main(String[] args) {
		/*
		 * 获取当前目录中的所有内容
		 */
		File dir = new File(".");
		/*
		 * boolean isFile()
		 * 判断当前File表示的是否为文件
		 *
		 * boolean isDirectory()
		 * 判断当前File表示的是否为目录
		 */
		if(dir.isDirectory()){
			//获取File表示的目录中的所有子项
			File[] subs = dir.listFiles();
			for(File sub : subs){
				System.out.println(sub.getName());
			}
		}

	}
}






