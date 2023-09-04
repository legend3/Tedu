package day06;

import java.io.File;

/**
 * 删除一个空目录
 * @author Administrator
 *
 */
public class FileDemo5 {
	public static void main(String[] args) {
		/*
		 * 删除当前目录下的demo目录
		 */
		File dir = new File("demo");
		if(dir.exists()){
			/*
			 * 若删除的是目录，必须保证该目录是一个
			 * 空目录才可以被删除成功。
			 */
			dir.delete();
			System.out.println("删除完毕!");
		}
	}
}






