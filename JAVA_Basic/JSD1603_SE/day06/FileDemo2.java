package day06;

import java.io.File;
import java.io.IOException;

/**
 * ʹ��File����һ���ļ�
 * @author Administrator
 *
 */
public class FileDemo2 {
	public static void main(String[] args) throws IOException {
		/*
		 * ��ǰĿ¼�´���test.txt�ļ�
		 * 
		 * ·����"./"���Ժ��Բ�д��Ĭ�Ͼ���
		 * ��ǰĿ¼��
		 */
		File file = new File("test.txt");
		/*
		 * boolean exists()
		 * �жϵ�ǰFile��ʾ���ļ���Ŀ¼�Ƿ�
		 * ��ʵ����
		 */
		//�������򴴽�
		if(!file.exists()){
			//�������ļ�
			file.createNewFile();
			System.out.println("�������!");
		}else{
			System.out.println("���ļ��Ѵ���!");
		}
		
		
	}
}




