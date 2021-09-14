package day10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Demo01 {

	public static void main(String[] args)
		throws Exception {
		
		InputStreamReader isr = 
			new InputStreamReader(System.in);
		//BufferedReader依赖于isr
		BufferedReader in = 
			new BufferedReader(isr);
		//从控制台读取一行文本信息
		String s = in.readLine();
		//System.out.println(s);
		//不要将操作系统控制台流关闭！
		
		/**
		 * autoFlush 参数，设置为true时候，
		 * 会在println方法执行结束以后自动
		 * 调用flush一次
		 */
		PrintWriter out = new PrintWriter(System.out,true);
		out.println(s); 
		//out.flush();
	}

}



