package day06;

import java.io.File;
import java.io.FileFilter;
/**
 * ��ȡһ��Ŀ¼�з��������Ĳ�������
 * 
 * File�ṩ��һ�����ص�listFiles()����:
 * File[] listFiles(FileFilter filter)
 * ���ݸ����Ĺ�����������ǰĿ¼�з��Ϲ�����Ҫ���
 * ����ء�
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
	 * accept�������ڶ�����˹���
	 * �������Ĳ�����File��������Ҫ�󣬷���
	 * Ӧ������true.
	 */
	public boolean accept(File file){
		String name = file.getName();
		System.out.println("���ڹ���:"+name);
		return name.startsWith(".");
	}
	
}





