package day06;

import java.io.File;

/**
 * ʹ��Fileɾ��һ�������ļ�
 * @author Administrator
 *
 */
public class FileDemo3 {
	public static void main(String[] args) {
		/*
		 * ɾ����ǰ��Ŀ��Ŀ¼�е�test.txt
		 */
		File file = new File("test.txt");
		if(file.exists()){
			//ɾ���ļ�
			file.delete();
			System.out.println("ɾ�����");
		}else{
			System.out.println("�ļ�������!");
		}
	}
}








