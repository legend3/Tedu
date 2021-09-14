package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ��߶�д�����������ٶ�д�������������
 * ��дЧ��
 * @author Administrator
 *
 */
public class CopyDemo2 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile src
			= new RandomAccessFile(
                "movie.flv","r"
			);

		RandomAccessFile desc
			= new RandomAccessFile(
				"movie_copy1.flv","rw"	
			);
		
		//10k����
		byte[] buf = new byte[1024*10];
		int len = -1;
		long start = System.currentTimeMillis();
		while((len = src.read(buf))!=-1){
			/*
			 * д��������ָ����Χ�ڵ��ֽ�
			 */
			desc.write(buf,0,len);
		}
		long end = System.currentTimeMillis();
		System.out.println("�������!��ʱ:"+(end-start)+"ms");
		src.close();
		desc.close();
	}
}



