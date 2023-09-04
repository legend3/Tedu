package day04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * �����������
 * ����һ���������ڣ��Լ�һ�������ڵ�����
 * ��������Ϊ�����յ�ǰ2�ܵ�����
 * @author Administrator
 *
 */
public class HomeWork01 {
	public static void main(String[] args) throws ParseException {
		Scanner scanner 
			= new Scanner(System.in);
		System.out.println("��������������:(yyyy-MM-dd)");
		String dateStr = scanner.nextLine();
		
		System.out.println("�����뱣����:(����)");
		String dayStr = scanner.nextLine();
		int day = Integer.parseInt(dayStr);
		
		SimpleDateFormat sdf
			= new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(dateStr);
		
		Calendar calendar 
			= Calendar.getInstance();
		calendar.setTime(date);
		
		//���������
		calendar.add(Calendar.DAY_OF_YEAR, day);
		
		//ǰ2��
		calendar.add(Calendar.DAY_OF_YEAR, -14);
		
		//����Ϊ����
		calendar.set(Calendar.DAY_OF_WEEK, 4);
		
		date = calendar.getTime();
		
		System.out.println("��������Ϊ:"+sdf.format(date));
		
		
	}
}






