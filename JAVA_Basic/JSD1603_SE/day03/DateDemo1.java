package day03;

import java.util.Date;

/**
 * java.util.Date
 * Date��ÿһ��ʵ�����ڱ�ʾһ��ȷ�е�ʱ���
 * �ڲ�ά��һ��longֵ����ֵ��ʾ��1970��Ԫ��
 * ����ʾ��ʱ���֮���������ĺ��롣
 * ����Date����ʱ����ǧ������⣬���Դ󲿷ַ���
 * �Ѿ�����עΪ"��ʱ��",�¿�������ĿӦ����ʹ��
 * ��Щ������
 * 
 * @author Administrator
 *
 */
public class DateDemo1 {
	public static void main(String[] args) {
		/*
		 * Ĭ�ϴ�����Date��ʾ��ǰϵͳʱ��
		 */
		Date date = new Date();
		
		System.out.println(date);
		
		/*
		 * ��ȡDate�ڲ�ά����longֵ
		 * long getTime()
		 */
		long time = date.getTime();
		System.out.println(time);
		
		//������һ�̵ĺ���
		time += 1000*60*60*24;
		
		date.setTime(time);
		System.out.println(date);
		
	}
}







