package day06;

import java.io.File;
import java.io.IOException;

/**
 * 使用File创建一个文件
 * @author Administrator
 *
 */
public class FileDemo2 {
	public static void main(String[] args) throws IOException {
		/*
		 * 当前目录下创建test.txt文件
		 *
		 * 路径中"./"可以忽略不写，默认就是
		 * 当前目录。
		 */
		File file = new File("test.txt");
		/*
		 * boolean exists()
		 * 判断当前File表示的文件或目录是否
		 * 真实存在
		 */
		//不存在则创建
		if(!file.exists()){
			//创建该文件
			file.createNewFile();
			System.out.println("创建完毕!");
		}else{
			System.out.println("该文件已存在!");
		}


	}
}




