package day03;

import java.util.Calendar;

/**
 * Calendar�ṩ�˿�����Բ�ͬʱ�����(ʱ�䵥λ)
 * ��������ֵ����ط�����
 * void set(int field,int value)
 * ��ָ����ʱ���������ָ����ֵ��
 * @author Administrator
 *
 */
public class CalendarDemo2 {
	public static void main(String[] args) {
		Calendar calendar
			= Calendar.getInstance();
		System.out.println(calendar.getTime());
		
		/*
		 * ����Ϊ2008-08-08 20:08:08
		 */
		//������
		calendar.set(Calendar.YEAR, 2008);
		System.out.println(calendar.getTime());
		
		/*
		 * ������
		 * �·ݴ�0��ʼ��0��ʾ1�¡�
		 * ����ʹ�ö�Ӧ�ĳ�����
		 */
//		calendar.set(Calendar.MONTH, Calendar.AUGUST);
		calendar.set(Calendar.MONTH, 7);
		System.out.println(calendar.getTime());
	
		/*
		 * ������
		 * ������Ӧ��ʱ�����:
		 * DATE,DAY_OF_MONTH:���е���
		 * DAY_OF_WEEK:���е��죬���ڼ�
		 * DAY_OF_YEAR:���е��졣
		 */
		calendar.set(Calendar.DAY_OF_MONTH, 8);
		System.out.println(calendar.getTime());
		
		calendar.set(Calendar.HOUR_OF_DAY, 20);
		calendar.set(Calendar.MINUTE, 8);
		calendar.set(Calendar.SECOND, 8);
		System.out.println(calendar.getTime());
		/*
		 * �����ܼ�ʱҪע�⣬
		 * 1��ʾ���գ�2��ʾ��һ���Դ�����
		 * Ҳ����ʹ�ó�����
		 */
		calendar.set(Calendar.DAY_OF_WEEK, 2);
		System.out.println(calendar.getTime());
	}
}





