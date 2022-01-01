package day06;

import java.io.File;

/**
 * 使用File对象创建一个目录
 * @author Administrator
 *
 */
public class FileDemo4 {
	public static void main(String[] args) {
		/*
		 * 在当前目录下创建目录"demo"
		 */
		File dir = new File("demo");
		if(!dir.exists()){
			//创建该目录
			dir.mkdir();
			System.out.println("创建完毕!");
		}
	}
}






