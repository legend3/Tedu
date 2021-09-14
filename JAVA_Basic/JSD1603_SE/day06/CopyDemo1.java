package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 复制文件
 * @author Administrator
 *
 */
public class CopyDemo1 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile src
			= new RandomAccessFile(
                "movie.flv","r"
			);
	
		RandomAccessFile desc
			= new RandomAccessFile(
				"movie_copy.flv","rw"	
			);
		//保存每次读取的字节
		int d = -1;
		long start = System.currentTimeMillis();
		while((d =src.read())!=-1){
			desc.write(d);
		}
		long end = System.currentTimeMillis();
		System.out.println("复制完毕!耗时:"+(end-start)+"ms");
		src.close();
		desc.close();
	}
}
