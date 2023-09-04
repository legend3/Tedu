package day06;

import java.io.File;

/**
 * ɾ������File��ʾ���ļ���Ŀ¼
 * 
 * 
 * ��д��һ�δ��룬������30��
 * Ҫ�����1+2+3+4+....100
 * ÿ��һ�����һ�ν����
 * ����δ����в��ó���for while�ؼ���
 * 
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
		File dir = new File("a");
		//ɾ��aĿ¼
		delete(dir);
		System.out.println("ɾ�����!");
	}
	
	public static void delete(File file){
		if(file.isDirectory()){
			//��ɾ��Ŀ¼�����������
			File[] subs = file.listFiles();
			for(File sub : subs){
				//�ݹ�
				delete(sub);
			}
		}
		file.delete();
	}
}








