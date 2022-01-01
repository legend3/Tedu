package day06;

import java.io.File;
import java.io.FileFilter;
/**
 * 获取一个目录中符合条件的部分子项
 *
 * File提供了一个重载的listFiles()方法:
 * File[] listFiles(FileFilter filter)
 * 根据给定的过滤器，将当前目录中符合过滤器要求的
 * 子项返回。
 * @author Administrator
 *
 */
public class FileDemo8 {
	public static void main(String[] args) {
		File dir = new File(".");
		MyFilter filter = new MyFilter();
		File[] subs = dir.listFiles(filter);
		for(File sub : subs){
			System.out.println(sub.getName());
		}
	}
}

class MyFilter implements FileFilter{
	/**
	 * accept方法用于定义过滤规则
	 * 当给定的参数的File对象满足要求，方法
	 * 应当返回true.
	 */
	public boolean accept(File file){
		String name = file.getName();
		System.out.println("正在过滤:"+name);
		return name.startsWith(".");
	}

}





