package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 使用SimpleDateFormat将
 * 字符串按照指定的日期格式解析为Date对象
 * @author Administrator
 *
 */
public class SimpleDateFormatDemo2 {
	public static void main(String[] args) throws ParseException {
		String str
				= "2008/08/08 20:08:08";

		SimpleDateFormat sdf
				= new SimpleDateFormat(
				"yyyy/MM/dd HH:mm:ss"
		);

		//String-->Date
		Date date = sdf.parse(str);

		System.out.println(date);

	}
}






