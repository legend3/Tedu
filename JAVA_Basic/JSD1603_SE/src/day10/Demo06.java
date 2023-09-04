package day10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo06 {

	public static void main(String[] args) {
		/*
		 * NumberFormatException 是
		 * RuntimeException 的子类型，编译器
		 * 不检查此类异常语法。
		 */
		int n = Integer.parseInt("你好");
		System.out.println(n);
		
		String str = "2016-7-7";
		SimpleDateFormat fmt = 
			new SimpleDateFormat("yyyy-M-d");
		//ParseException 是"可检查异常"
		//编译器检查语法：如果方法抛出可检查
		//异常，则必须处理异常，否则编译错误
		// 强迫程序员，必须考虑进行适当的意外
		// 错误处理，避免运行期间的麻烦！
		Date date;
		try{
			date= fmt.parse(str);
		}catch(ParseException e){
			e.printStackTrace();
			date = new Date();
		}
		System.out.println(date); 
	}
}

