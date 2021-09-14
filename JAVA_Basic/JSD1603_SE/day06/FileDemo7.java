package day06;

import java.io.File;

/**
 * ��ȡһ��Ŀ¼�е���������
 * @author Administrator
 *
 */
public class FileDemo7 {
	public static void main(String[] args) {
		/*
		 * ��ȡ��ǰĿ¼�е���������
		 */
		File dir = new File(".");
		/*
		 * boolean isFile()
		 * �жϵ�ǰFile��ʾ���Ƿ�Ϊ�ļ�
		 * 
		 * boolean isDirectory()
		 * �жϵ�ǰFile��ʾ���Ƿ�ΪĿ¼
		 */
		if(dir.isDirectory()){
			//��ȡFile��ʾ��Ŀ¼�е���������
			File[] subs = dir.listFiles();
			for(File sub : subs){
				System.out.println(sub.getName());
			}
		}
		
	}
}






