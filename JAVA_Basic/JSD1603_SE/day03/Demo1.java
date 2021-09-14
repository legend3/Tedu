package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 要求用户输入自己的生日
 * 格式为:yyyy-MM-dd
 * 经过计算，输出:到今天为止活了多少天?
 * @author Administrator
 *
 */
public class Demo1 {
	public static void main(String[] args) throws ParseException {
		Scanner scanner 
			= new Scanner(System.in);
		
		System.out.println("请输入您的生日:(yyyy-mm-dd)");
		String birthStr = scanner.nextLine();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//生日
		Date birth = sdf.parse(birthStr);
		//今天
		Date now = new Date();
		
		long time = now.getTime()-birth.getTime();
		long days = time/1000/60/60/24;
		
		System.out.println("恭喜您!到今天为止，您活了:"+days+"天，请继续保持哦！");
	}
}








