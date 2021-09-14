package day08;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Demo06 {

	public static void main(
		String[] args) throws Exception{
		FileInputStream in = 
			new FileInputStream(
                    "movie.flv");
		FileOutputStream out = 
			new FileOutputStream(
				"new.flv");
		int n;
		byte[] buf = new byte[8*1024];
		while((n = in.read(buf))!=-1){
			out.write(buf, 0, n); 
		}
		in.close();
		out.close();
		System.out.println("完成！");
	}
}





