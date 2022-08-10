package day03;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SimpleDateFormat可以根据指定的日期格式
 * 将String与Date之间互相转换。
 * @author Administrator
 *
 */
public class SimpleDateFormatDemo1 {
	public static void main(String[] args) {
		/*
		 * 从Date转换为String
		 * 
		 * 将当前系统时间按照
		 * 2016-04-26 10:34:55
		 * yyyy-MM-dd HH:mm:ss
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		System.out.println(date);
		//Date-->String
		String str = sdf.format(date);
		System.out.println(str);
	}
}






