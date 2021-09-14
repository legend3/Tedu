package day03;

import java.util.Calendar;

/**
 * ��ȡĳһ��ʱ���������Ӧ��ֵ:
 * int get(int field)
 * @author Administrator
 *
 */
public class CalendarDemo3 {
	public static void main(String[] args) {
		Calendar calendar
			= Calendar.getInstance();
		
		//��ȡ��
		int year 
			= calendar.get(Calendar.YEAR);
		
		int month 
			= calendar.get(Calendar.MONTH)+1;
		
		int day 
			= calendar.get(Calendar.DATE);
		System.out.println(
			year+"-"+month+"-"+day);
		
		int hour 
			= calendar.get(Calendar.HOUR_OF_DAY);
		
		int min 
			= calendar.get(Calendar.MINUTE);
		
		int sec
			= calendar.get(Calendar.SECOND);
		System.out.println(hour+":"+min+":"+sec);
		
		int dow
			= calendar.get(Calendar.DAY_OF_WEEK);
		String[] data 
			= {"��","һ","��","��","��","��","��"};
		System.out.println("��"+data[dow-1]);
		
		/*
		 * ��ȡĳһ��ʱ���������������ֵ
		 */
		int max = calendar.getActualMaximum(
			Calendar.DAY_OF_MONTH
		);
		System.out.println("����µ���:"+max+"��");
	}
}






