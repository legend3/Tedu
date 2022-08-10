package day03;

import java.util.Calendar;

/**
 * void add(int field,int value)
 * �Ը�����ʱ������ۼӸ�����ֵ����value��
 * ����������������������
 * @author Administrator
 *
 */
public class CalendarDemo4 {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		
		/*
		 * ����3��2������25���Ժ��ǰ3��������?
		 */
		calendar.add(Calendar.YEAR, 3);
		calendar.add(Calendar.MONTH, 2);
		calendar.add(Calendar.DAY_OF_YEAR, 25);
		calendar.add(Calendar.DAY_OF_YEAR, -3);
		System.out.println(calendar.getTime());
		/*
		 * 2019-07-18 xx:xx:xx
		 */
		
	}
}







