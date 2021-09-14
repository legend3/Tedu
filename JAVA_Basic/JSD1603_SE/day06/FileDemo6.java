package day06;

import java.io.File;

/**
 * �����༶Ŀ¼
 * @author Administrator
 *
 */
public class FileDemo6 {
	public static void main(String[] args) {
		/*
		 * �ڵ�ǰĿ¼�´���:
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
			 * mkdirs�����ڴ�����ǰĿ¼��ͬʱ
			 * ��ͬ�������в����ڵĸ�Ŀ¼
			 */
			dir.mkdirs();
			System.out.println("�������!");
		}
	}
}




