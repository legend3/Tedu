package day10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

 
public class IOUtils {
	/**
	 * 封装一个算法实现文件的复制功能
	 * @param src 原文件
	 * @param dst 目标文件
	 * @throws 复制失败时候抛出异常
	 * 
	 * 当算法（方法）执行出现意外情况时，
	 * 抛出异常作为意外的结果，使用throws
	 * 声明方法可能有异常情况发生
	 */
	public static void cp(String src, String dst) throws IllegalArgumentException {
		FileInputStream in=null;
		FileOutputStream out = null;
		try {
			in=new FileInputStream(src);
			out=new FileOutputStream(dst);
			int n;
			byte[] buf = new byte[1024*8];
			while((n=in.read(buf))!=-1){
				out.write(buf, 0, n);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			//System.out.println("木有文件!");
			//抛出异常，通知调用者，当前算法
			//发生了意外情况，throw语句结束
			//了当前方法。
			throw new IllegalArgumentException("木有文件!");
		} catch (IOException e) {
			e.printStackTrace();
			//System.out.println("读写失败!");
			throw new IllegalArgumentException(
					"读写失败!");
		}finally{
			try{
				if(in!=null) in.close();
				if(out!=null) out.close();
			}catch(IOException e){
			}
		}
	}
}



