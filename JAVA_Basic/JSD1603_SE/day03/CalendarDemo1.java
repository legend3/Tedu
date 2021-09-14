package day03;

import java.util.Calendar;
import java.util.Date;

/**
 * java.util.Calendar
 * 日历类，是一个抽象类，定义了针对某一种日期
 * 历法的时间相关操作。
 * 有很多子类实现，最长用的就是阳历历法:
 * GregroianCalendar
 * Calendar提供了静态方法来获取一个当前系统
 * 所在地区适用的日历实现类。大部分地区返回的
 * 也都是阳历立法。
 * @author Administrator
 *
 */
public class CalendarDemo1 {
	public static void main(String[] args) {
		/*
		 * 获取回来的实现类表示当前系统时间。
		 * 
		 */
		Calendar calendar
			= Calendar.getInstance();
		/*
		 * Calendar实现类的toString不能直观
		 * 反映出具体时间。
		 */
		System.out.println(calendar);
		
		/*
		 * Calendar-->Date
		 * Date getTime()
		 * Calendar提供了一个方法getTime，
		 * 该方法可以将自身表示的日期时间以
		 * 一个Date对象形式返回。
		 */
		Date date = calendar.getTime();
		System.out.println(date);
		
		/*
		 * Date-->Calendar
		 * void setTime(Date date)
		 * Calendar提供了方法setTime,可以
		 * 将给定的Date对象传入，以使得当前
		 * Calendar表示给定Date所表示的
		 * 日期。
		 */
		calendar.setTime(date);
		
		/*
		 * Date,SimpleDateFormat,Calendar
		 * 配合使用的大致流程与情景。
		 * 用户输入一个日期，然后根据一系列的
		 * 计算，最后在将得出的日期显示给用户。
		 * 例如:
		 * 用户输入一个商品的生产日期，和保质期
		 * 的天数，查看过期的日期。
		 * 流程:
		 * 1:用户输入一个日期，和其他信息。
		 * 2:将用户输入的日期(字符串)通过
		 *   SimpleDateFormat转换为Date
		 * 3:将Date转换为Calendar
		 * 4:通过Calendar对时间进行一系列的计算
		 * 5:将计算后的Calendar表示的时间再
		 *   转换为Date
		 * 6:将Date通过SimpleDateFormat
		 *   转换为字符串
		 * 7:输出给用户日期结果。      
		 * 
		 */
	}
}







