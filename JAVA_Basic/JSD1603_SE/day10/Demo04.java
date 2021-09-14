package day10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo04 {
	public static void main(String[] args){
		//将in和out在try外部创建，才能在finally
		//中使用这两个变量
		FileInputStream in = null;
		FileOutputStream out = null;
		try{
			in=new FileInputStream("move.flv");
			out=new FileOutputStream("demo.flv");
			int n;
			byte[] buf = new byte[1024*8];
			while((n = in.read(buf))!=-1){
				out.write(buf, 0, n);
			}
			//in.close();
			//out.close();
		}catch(FileNotFoundException e){
			System.out.println("没有文件");
		}catch (IOException e) {
			System.out.println("读写故障"); 
		}finally{
			//finally用于可靠的释放资源！
			// 在finally中关闭文件，才更加可靠
			try{
				if(in!=null)//为了避免出现空指针异常
					in.close();
				if(out!=null)
					out.close();
			}catch(IOException e){
			}
		}
	}
}
