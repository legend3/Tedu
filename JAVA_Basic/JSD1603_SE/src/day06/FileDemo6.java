package day06;

import java.io.File;

/**
 * 创建多级目录
 * @author Administrator
 *
 */
public class FileDemo6 {
	public static void main(String[] args) {
		/*
		 * 在当前目录下创建:
		 * a/b/c/d/e/f
		 */
		File dir = new File(
				"a"+File.separator+
						"b"+File.separator+
						"c"+File.separator+
						"d"+File.separator+
						"e"+File.separator+
						"f"
		);
		if(!dir.exists()){
			/*
			 * mkdirs可以在创建当前目录的同时
			 * 连同创建所有不存在的父目录
			 */
			dir.mkdirs();
			System.out.println("创建完毕!");
		}
	}
}




