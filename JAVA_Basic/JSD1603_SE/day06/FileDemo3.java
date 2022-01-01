package day06;

import java.io.File;

/**
 * 使用File删除一个现有文件
 * @author Administrator
 *
 */
public class FileDemo3 {
	public static void main(String[] args) {
		/*
		 * 删除当前项目根目录中的test.txt
		 */
		File file = new File("test.txt");
		if(file.exists()){
			//删除文件
			file.delete();
			System.out.println("删除完毕");
		}else{
			System.out.println("文件不存在!");
		}
	}
}








