package day06;

import java.io.File;

/**
 * ɾ��һ����Ŀ¼
 * @author Administrator
 *
 */
public class FileDemo5 {
	public static void main(String[] args) {
		/*
		 * ɾ����ǰĿ¼�µ�demoĿ¼
		 */
		File dir = new File("demo");
		if(dir.exists()){
			/*
			 * ��ɾ������Ŀ¼�����뱣֤��Ŀ¼��һ��
			 * ��Ŀ¼�ſ��Ա�ɾ���ɹ���
			 */
			dir.delete();
			System.out.println("ɾ�����!");
		}
	}
}






