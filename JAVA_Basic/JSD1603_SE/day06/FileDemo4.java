package day06;

import java.io.File;

/**
 * ʹ��File���󴴽�һ��Ŀ¼
 * @author Administrator
 *
 */
public class FileDemo4 {
	public static void main(String[] args) {
		/*
		 * �ڵ�ǰĿ¼�´���Ŀ¼"demo"
		 */
		File dir = new File("demo");
		if(!dir.exists()){
			//������Ŀ¼
			dir.mkdir();
			System.out.println("�������!");
		}
	}
}






